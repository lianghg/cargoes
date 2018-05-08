package cargoes.service.impl;

import org.springframework.stereotype.Service;

import cargoes.model.po.OperationLog;
import cargoes.model.po.OperationLogExample;
import cargoes.service.OperationLogService;

@Service
public class OperationLogServiceImpl extends AbstractServiceImpl<OperationLog,OperationLogExample> implements OperationLogService{

}
