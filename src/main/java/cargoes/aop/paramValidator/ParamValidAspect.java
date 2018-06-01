package cargoes.aop.paramValidator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import cargoes.util.MessageSourceUtils;

@Aspect
@Configuration
public class ParamValidAspect {
	
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final ExecutableValidator methodValidator = factory.getValidator().forExecutables();
    private final Validator beanValidator = factory.getValidator();

//    切入点
    @Pointcut("execution(* cargoes.service.*.*(..))")
    public void validate(){}

//    切入时机 
    @Before("validate()")
    public void validator(JoinPoint point) throws Exception {
    	List<String> errorMsg = new ArrayList<String>(0);
        // 目标对象
        Object target = point.getThis();
        // 方法的参数
        Object [] args = point.getArgs();
        // 切入方法
        Method method = ((MethodSignature)point.getSignature()).getMethod();

        Set<ConstraintViolation<Object>> validResult = validMethodParams(target, method, args);

        Iterator<ConstraintViolation<Object>> violationIterator = validResult.iterator();
        while (violationIterator.hasNext()) {
        	String msg = violationIterator.next().getMessage();
            errorMsg.add(msg);//
        }

        for (Object bean : args) {
            if (null != bean) {
                validResult = validBeanParams(bean);
                violationIterator = validResult.iterator();
                while (violationIterator.hasNext()) {
                	String msg = violationIterator.next().getMessage();
                    errorMsg.add(msg);//
                }
            }
        }
        
        if(errorMsg.size() > 0){
        	
        	String msg = errorMsg.toString().substring(1, errorMsg.toString().length()-1);
        	
        	throw new IllegalArgumentException(msg);
        }
    }
    
    private <T> Set<ConstraintViolation<T>> validMethodParams(T obj, Method method, Object [] params){
        return methodValidator.validateParameters(obj, method, params);
    }

    private <T> Set<ConstraintViolation<T>> validBeanParams(T bean) {
        return beanValidator.validate(bean);
    }
}