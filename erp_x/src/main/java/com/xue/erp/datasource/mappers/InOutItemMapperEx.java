package com.xue.erp.datasource.mappers;

import com.xue.erp.datasource.entities.InOutItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InOutItemMapperEx {

    List<InOutItem> selectByConditionInOutItem(
            @Param("name") String name,
            @Param("type") String type,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByInOutItem(
            @Param("name") String name,
            @Param("type") String type,
            @Param("remark") String remark);
}