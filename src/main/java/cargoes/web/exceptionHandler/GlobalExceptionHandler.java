package cargoes.web.exceptionHandler;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

import cargoes.model.dto.DataEntity;
import cargoes.util.MessageSourceUtils;
import cargoes.web.exception.ResourceNotFound;
import cargoes.web.exception.UserActivationException;

@ControllerAdvice
@SuppressWarnings("rawtypes")
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<DataEntity> showIllegalArgs(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {

		DataEntity dataEntity = DataEntity(ex);
		dataEntity.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<DataEntity> showNotFound(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {

		DataEntity dataEntity = DataEntity(ex);
		dataEntity.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserActivationException.class)
	public ResponseEntity<DataEntity> showUserActivationError(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {

		DataEntity dataEntity = DataEntity(ex);
		dataEntity.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<DataEntity> showAccessDenied(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {

		DataEntity dataEntity = DataEntity(ex);
		dataEntity.setStatus(HttpStatus.FORBIDDEN.value());
		
		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<DataEntity> showTheRestError(HttpServletResponse response, Exception ex, HandlerMethod handlerMethod) {
		
		DataEntity dataEntity = DataEntity(ex);
		dataEntity.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<DataEntity>(dataEntity, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private DataEntity DataEntity(Exception ex) {
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(false);
		dataEntity.setMessage(MessageSourceUtils.analyseMsg(ex.getMessage()));
		dataEntity.setTimestamp(new Date());
		dataEntity.setException(ex.getClass().getName());
		return dataEntity;
	}
	
}