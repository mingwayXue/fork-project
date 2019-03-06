package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapperEx {

    List<Person> selectByConditionPerson(
            @Param("name") String name,
            @Param("type") String type,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByPerson(
            @Param("name") String name,
            @Param("type") String type);
}