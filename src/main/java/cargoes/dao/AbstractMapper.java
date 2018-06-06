package cargoes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AbstractMapper<E> {

	int deleteByPrimaryKey(String id);

	int insert(E record);

	int insertSelective(E record);

	int updateByPrimaryKeySelective(E record);

	int updateByPrimaryKey(E record);

	E selectByPrimaryKey(String id);

	List<E> selectByPrimaryKeys(@Param("ids") List<String> ids);
	
}
