package cargoes.web.aop.operationLogHandler;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import cargoes.annotation.Operation;
import cargoes.model.po.OperationLog;
import cargoes.service.OperationLogService;

/*
 * 前置通知（@Before）：在某连接点（join point）之前执行的通知，但这个通知不能阻止连接点前的执行（除非它抛出一个异常）
 * 返回后通知（@AfterReturning）：在某连接点（join point）正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回
 * 抛出异常后通知（@AfterThrowing）：方法抛出异常退出时执行的通知
 * 后通知（@After）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出） 环绕通知（@Around）
 */

@Component
@Aspect
public class OperationLogHandler {

	@Autowired
	private OperationLogService operationLogService;

	@Pointcut("within(cargoes.web.controller..*) && @annotation(cargoes.annotation.Operation)") //
	public void logPointcut() {
	}

	// 记录日志
	@Around("logPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint point) throws Throwable {
		
		long begin = 0L;
		long end = 0L;
		int operationStatus = OperationLog.OPERATION_STATUS_SUCCESS;
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		Object [] args = point.getArgs();
		
		String ip = request.getRemoteAddr();
		String optionType = checkOperation(point);
		String url = request.getRequestURL().toString();
		String requestType = request.getMethod();
		String invokedMethod = "";
		invokedMethod += point.getSignature().getDeclaringTypeName();//
		invokedMethod += "." + point.getSignature().getName();//
		String requestInfo = "";
		
		if(args!= null){
			requestInfo = JSON.toJSONString(args);
		}
		
		OperationLog operationLog = new OperationLog();
		operationLog.setId(UUID.randomUUID().toString());
		operationLog.setUserId("");
		operationLog.setIp(ip);
		operationLog.setRequestType(requestType);
		operationLog.setOperationDesc(optionType);
		operationLog.setRequestUrl(url);
		operationLog.setRequestInfo(requestInfo);
		operationLog.setOperationTime(new Date());

		Object object = null;
		try {
			begin = System.currentTimeMillis();
			object = point.proceed();

		} catch (Throwable e) {
			operationStatus = OperationLog.OPERATION_STATUS_FAIL;
			operationLog.setErrorMessage(e.toString());
			throw e;
		}finally{
			int consumedTime = 0;
			end = System.currentTimeMillis();
			consumedTime = (int) (end-begin);
			operationLog.setConsumedTime(consumedTime);
			operationLog.setOperationStatus(operationStatus);
			operationLog.setInvokedMethod(invokedMethod);
			operationLogService.insert(operationLog);
		}
		return object;
	}

	private String checkOperation(JoinPoint point) {

		Class<?> clazz = null;
		Object[] args = null;
		String methodName = "";
		String optionValue = "";

		methodName = point.getSignature().getName();
		clazz = point.getTarget().getClass();
		args = point.getArgs();

		Method[] methods = clazz.getDeclaredMethods();
		Operation optionAnnotation = null;
		for (Method method : methods) {
			if (method.getName().equals(methodName) && method.getParameterTypes().length == args.length) {
				optionAnnotation = AnnotationUtils.findAnnotation(method, Operation.class);
				if (optionAnnotation != null) {
					optionValue = optionAnnotation.value();
					break;
				}
			}
		}

		return optionValue;

	}

}
