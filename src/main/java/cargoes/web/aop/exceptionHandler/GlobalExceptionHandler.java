package cargoes.web.aop.exceptionHandler;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

import cargoes.web.exception.ResourceNotFound;
import cargoes.web.exception.UserActivationException;
import cargoes.web.response.model.DefaultDataEntity;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<DefaultDataEntity> showIllegalArgs(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {

		DefaultDataEntity dataEntity = buildDataEntity(ex);
		dataEntity.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<DefaultDataEntity>(dataEntity, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<DefaultDataEntity> showNotFound(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {

		DefaultDataEntity dataEntity = buildDataEntity(ex);
		dataEntity.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<DefaultDataEntity>(dataEntity, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserActivationException.class)
	public ResponseEntity<DefaultDataEntity> showUserActivationError(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {

		DefaultDataEntity dataEntity = buildDataEntity(ex);
		dataEntity.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<DefaultDataEntity>(dataEntity, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<DefaultDataEntity> showTheRestError(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {
		
		DefaultDataEntity dataEntity = buildDataEntity(ex);
		dataEntity.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<DefaultDataEntity>(dataEntity, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private DefaultDataEntity buildDataEntity(Exception ex) {
		DefaultDataEntity dataEntity = new DefaultDataEntity();
		dataEntity.setFlag(false);
		dataEntity.setMessage(ex.getMessage());
		dataEntity.setTimestamp(new Date());
		dataEntity.setException(ex.getClass().getName());
		return dataEntity;
	}
	
}