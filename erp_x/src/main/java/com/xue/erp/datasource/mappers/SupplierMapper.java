package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.Supplier;
import com.xue.erp.datasource.entities.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int countByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int deleteByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int insert(Supplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int insertSelective(Supplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    List<Supplier> selectByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    Supplier selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Supplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Supplier record);
}