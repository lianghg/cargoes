package cargoes.dao;

import cargoes.model.po.SysUser;
import cargoes.model.po.SysUserExample;

public interface SysUserMapper extends AbstractMapper<SysUser,SysUserExample>{

	SysUser loadUserByUsername(String username);
}