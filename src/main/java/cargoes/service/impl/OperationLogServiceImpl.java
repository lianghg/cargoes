package cargoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cargoes.dao.OperationLogMapper;
import cargoes.model.po.OperationLog;
import cargoes.service.OperationLogService;

@Service
public class OperationLogServiceImpl extends AbstractServiceImpl<OperationLog> implements OperationLogService{

	@Autowired
	private OperationLogMapper operationLogMapper;
	
	@Override
	public OperationLogMapper getMapper() {
		return operationLogMapper;
	}
}
