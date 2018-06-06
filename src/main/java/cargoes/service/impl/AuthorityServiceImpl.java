package cargoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cargoes.dao.AuthorityMapper;
import cargoes.model.po.Authority;
import cargoes.service.AuthorityService;

@Service
public class AuthorityServiceImpl extends AbstractServiceImpl<Authority> implements AuthorityService{
	
	@Autowired
	private AuthorityMapper authorityMapper;
	
	@Override
	public AuthorityMapper getMapper() {
		return authorityMapper;
	}
}