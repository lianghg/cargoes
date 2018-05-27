package cargoes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AbstractMapper<E,T> {
	
	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int countByExample(T example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int deleteByExample(T example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int insert(E record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int insertSelective(E record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    List<E> selectByExample(T example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    E selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int updateByExampleSelective(@Param("record") E record, @Param("example") T example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int updateByExample(@Param("record") E record, @Param("example") T example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int updateByPrimaryKeySelective(E record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 
     *
     * @mbggenerated Wed Jan 17 15:51:51 CST 2018
     */
    int updateByPrimaryKey(E record);
}