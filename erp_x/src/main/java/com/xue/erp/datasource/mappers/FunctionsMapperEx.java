package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.Functions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionsMapperEx {

    List<Functions> selectByConditionFunctions(
            @Param("name") String name,
            @Param("type") String type,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByFunctions(
            @Param("name") String name,
            @Param("type") String type);
}