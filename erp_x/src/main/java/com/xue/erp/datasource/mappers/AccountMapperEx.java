package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.vo.AccountVo4InOutList;
import com.xue.erp.datasource.vo.AccountVo4List;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapperEx {

    List<AccountVo4List> selectByConditionAccount(
            @Param("name") String name,
            @Param("serialNo") String serialNo,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByAccount(
            @Param("name") String name,
            @Param("serialNo") String serialNo,
            @Param("remark") String remark);

    List<AccountVo4InOutList> findAccountInOutList(
            @Param("accountId") Long accountId,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    int findAccountInOutListCount(
            @Param("accountId") Long accountId);
}