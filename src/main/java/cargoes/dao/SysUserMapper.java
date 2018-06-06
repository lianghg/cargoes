package cargoes.dao;

import java.util.List;

import cargoes.model.po.SysUser;

public interface SysUserMapper extends AbstractMapper<SysUser>{

	List<SysUser> selectList();
	
	SysUser loadUserByUsername(String username);
}