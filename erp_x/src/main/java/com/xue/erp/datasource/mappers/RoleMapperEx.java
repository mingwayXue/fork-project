package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapperEx {

    List<Role> selectByConditionRole(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByRole(
            @Param("name") String name);
}