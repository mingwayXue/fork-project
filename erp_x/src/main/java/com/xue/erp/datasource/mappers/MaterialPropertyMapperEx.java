package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.MaterialProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialPropertyMapperEx {

    List<MaterialProperty> selectByConditionMaterialProperty(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByMaterialProperty(@Param("name") String name);
}