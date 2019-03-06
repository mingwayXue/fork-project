package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.Depot;
import com.xue.erp.datasource.entities.DepotEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DepotMapperEx {

    List<Depot> selectByConditionDepot(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByDepot(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark);

    List<DepotEx> getDepotList(Map<String, Object> params);
    Long getDepotListCount(Map<String, Object> params);
}