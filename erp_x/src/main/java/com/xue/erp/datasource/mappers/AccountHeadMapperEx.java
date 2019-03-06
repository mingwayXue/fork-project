package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.AccountHeadVo4ListEx;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AccountHeadMapperEx {

    List<AccountHeadVo4ListEx> selectByConditionAccountHead(
            @Param("type") String type,
            @Param("billNo") String billNo,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByAccountHead(
            @Param("type") String type,
            @Param("billNo") String billNo,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime);

    Long getMaxId();

    BigDecimal findAllMoney(
            @Param("supplierId") Integer supplierId,
            @Param("type") String type,
            @Param("modeName") String modeName,
            @Param("endTime") String endTime);

    List<AccountHeadVo4ListEx> getDetailByNumber(
            @Param("billNo") String billNo);
}