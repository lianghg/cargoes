package cargoes.web.response.model;

import java.util.Date;
import java.util.Map;

public class DefaultDataEntity extends DataEntity{

	public static final String DATA_ENTITY_RESULT = "result";
	public static final String DATA_ENTITY_MESSAGE = "message";
	public static final String DATA_ENTITY_STATUS = "status";
	public static final String DATA_ENTITY_FLAG = "flag";
	public static final String DATA_ENTITY_EXCEPTION= "exception";
	public static final String DATA_ENTITY_ERROR= "error";
	public static final String DATA_ENTITY_TIMESTAMP= "timestamp";
	
	@Override
	public Object getResult() {
		return get(DATA_ENTITY_RESULT);
	}
	
	@Override
	public void setResult(Object result) {
		setValue(DATA_ENTITY_RESULT, result);
	}
	
	@Override
	public String getMessage() {
		return getString(DATA_ENTITY_MESSAGE);
	}
	
	@Override
	public void setMessage(String message) {
		setValue(DATA_ENTITY_MESSAGE, message);
	}
	
	@Override
	public int getStatus() {
		return (int) get(DATA_ENTITY_STATUS);
	}
	
	@Override
	public void setStatus(int status) {
		setValue(DATA_ENTITY_STATUS, status);
		
	}

	@Override
	public boolean getFlag() {
		
		return (boolean) get(DATA_ENTITY_FLAG);
	}

	@Override
	public void setFlag(boolean flag) {
		
		setValue(DATA_ENTITY_FLAG, flag);
		
	}

	@Override
	public String getError() {
		
		return getString(DATA_ENTITY_ERROR);
	}

	@Override
	public void setError(String error) {
		
		setValue(DATA_ENTITY_ERROR, error);
		
	}

	@Override
	public Date getTimestamp() {
		
		return getDate(DATA_ENTITY_TIMESTAMP);
	}

	@Override
	public void setTimestamp(Date timestamp) {
		
		setValue(DATA_ENTITY_TIMESTAMP, timestamp);
	}

	@Override
	public String getException() {
		
		return getString(DATA_ENTITY_EXCEPTION);
	}

	@Override
	public void setException(String exception) {
		
		setValue(DATA_ENTITY_EXCEPTION, exception);
		
	}
	
}
