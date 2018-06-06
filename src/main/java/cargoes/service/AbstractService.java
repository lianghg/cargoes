package cargoes.service;

import java.util.List;

import cargoes.dao.AbstractMapper;

public interface AbstractService<E> {

	AbstractMapper<E> getMapper();

	int insert(E record);

	int insertSelective(E record);

	int updateByPrimaryKeySelective(E record);

	int updateByPrimaryKey(E record);

	int deleteByPrimaryKey(String id);

	int deleteByPrimaryKeys(List<String> ids);

	E selectByPrimaryKey(String id);

	List<E> selectByPrimaryKeys(List<String> ids);
}
