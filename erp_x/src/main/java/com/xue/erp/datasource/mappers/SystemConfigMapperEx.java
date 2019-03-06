package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.SystemConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemConfigMapperEx {

    List<SystemConfig> selectByConditionSystemConfig(
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsBySystemConfig();
}