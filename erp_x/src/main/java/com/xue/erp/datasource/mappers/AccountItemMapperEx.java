package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.AccountItem;
import com.xue.erp.datasource.vo.AccountItemVo4List;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountItemMapperEx {

    List<AccountItem> selectByConditionAccountItem(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByAccountItem(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark);

    List<AccountItemVo4List> getDetailList(
            @Param("headerId") Long headerId);

}