package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnitMapperEx {

    List<Unit> selectByConditionUnit(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByUnit(
            @Param("name") String name);
}