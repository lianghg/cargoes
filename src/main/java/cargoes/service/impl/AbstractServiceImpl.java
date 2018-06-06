package cargoes.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cargoes.dao.AbstractMapper;
import cargoes.service.AbstractService;

@Transactional
public abstract class AbstractServiceImpl<E> implements AbstractService<E>{

	@Override
	public abstract AbstractMapper<E> getMapper();

	@Override
	public int deleteByPrimaryKey(String id) {
		
		return getMapper().deleteByPrimaryKey(id);
	}

	@Override
	public int insert(E record) {
		
		return getMapper().insert(record);
	}

	@Override
	public int insertSelective(E record) {
		return getMapper().insertSelective(record);
	}

	@Override
	public E selectByPrimaryKey(String id) {
		
		return getMapper().selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(E record) {
		
		return getMapper().updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(E record) {
		
		return getMapper().updateByPrimaryKey(record);
	}

	@Override
	public List<E> selectByPrimaryKeys(List<String> ids) {
		
		return getMapper().selectByPrimaryKeys(ids);
	}

	@Override
	public int deleteByPrimaryKeys(List<String> ids) {
		
		return getMapper().deleteByPrimaryKeys(ids);
	}
	
	

	
}
