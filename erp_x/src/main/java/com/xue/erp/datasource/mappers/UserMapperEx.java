package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperEx {

    List<User> selectByConditionUser(
            @Param("userName") String userName,
            @Param("loginName") String loginName,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByUser(
            @Param("userName") String userName,
            @Param("loginName") String loginName);
}