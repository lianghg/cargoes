package cargoes.service;

import java.util.List;

import cargoes.dao.AbstractMapper;

public interface AbstractService <E,T> {
	
	AbstractMapper<E, T> getMapper();

    int countByExample(T example);

    int deleteByExample(T example);

    int deleteByPrimaryKey(String id);

    int insert(E record);

    int insertSelective(E record);

    List<E> selectByExample(T example);

    E selectByPrimaryKey(String id);

    int updateByExampleSelective(E record, T example);

    int updateByExample(E record, T example);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);
}
