package cargoes.model.po;

import java.util.Date;

public class OperationLog {
	
	public static int OPERATION_STATUS_SUCCESS = 1;
	public static int  OPERATION_STATUS_FAIL = 0;
	
	private String id;

	private String username;

	private String ip;

	private String requestUrl;

	private String requestType;

	private String requestInfo;

	private String operationDesc;

	private Date operationTime;

	private Integer operationStatus;

	private Integer consumedTime;

	private String invokedMethod;

	private String errorMessage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}

	public String getOperationDesc() {
		return operationDesc;
	}

	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public Integer getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(Integer operationStatus) {
		this.operationStatus = operationStatus;
	}

	public Integer getConsumedTime() {
		return consumedTime;
	}

	public void setConsumedTime(Integer consumedTime) {
		this.consumedTime = consumedTime;
	}

	public String getInvokedMethod() {
		return invokedMethod;
	}

	public void setInvokedMethod(String invokedMethod) {
		this.invokedMethod = invokedMethod;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}