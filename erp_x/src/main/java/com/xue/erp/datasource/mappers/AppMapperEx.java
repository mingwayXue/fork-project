package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.App;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppMapperEx {

    List<App> selectByConditionApp(
            @Param("name") String name,
            @Param("type") String type,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByApp(
            @Param("name") String name,
            @Param("type") String type);
}