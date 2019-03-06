package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.Functions;
import com.xue.erp.datasource.entities.FunctionsExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FunctionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int countByExample(FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int deleteByExample(FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int insert(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int insertSelective(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    List<Functions> selectByExample(FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    Functions selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Functions record, @Param("example") FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Functions record, @Param("example") FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table functions
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Functions record);
}