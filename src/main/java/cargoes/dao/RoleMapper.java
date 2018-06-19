package cargoes.dao;

import java.util.List;

import cargoes.model.po.Role;

public interface RoleMapper extends AbstractMapper<Role>{

	List<Role> selectList();

}