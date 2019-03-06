package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.AccountHead;
import com.xue.erp.datasource.entities.AccountHeadExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AccountHeadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int countByExample(AccountHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int deleteByExample(AccountHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int insert(AccountHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int insertSelective(AccountHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    List<AccountHead> selectByExample(AccountHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    AccountHead selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AccountHead record, @Param("example") AccountHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AccountHead record, @Param("example") AccountHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AccountHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table accounthead
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AccountHead record);
}