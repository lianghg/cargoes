package cargoes.service.impl;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cargoes.dao.AbstractMapper;
import cargoes.service.AbstractService;

@Transactional
public class AbstractServiceImpl<E,T> implements AbstractService<E,T>{

	@Autowired
	private AbstractMapper<E,T> mapper;
	
	@Override
	public AbstractMapper<E, T> getMapper() {
		return mapper;
	}

	public void setMapper(AbstractMapper<E, T> mapper) {
		this.mapper = mapper;
	}

	@Override
	public int countByExample(T example) {
		
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(T example) {
		
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(E record) {
		
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(E record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<E> selectByExample(T example) {
		
		return mapper.selectByExample(example);
	}

	@Override
	public E selectByPrimaryKey(String id) {
		
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(E record, T example) {
		
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(E record, T example) {
		
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(E record) {
		
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(E record) {
		
		return mapper.updateByPrimaryKey(record);
	}

	
}
