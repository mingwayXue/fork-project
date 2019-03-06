package com.xue.erp.service.materialProperty;

import com.alibaba.fastjson.JSONObject;
import com.xue.erp.datasource.entities.MaterialProperty;
import com.xue.erp.datasource.entities.MaterialPropertyExample;
import com.xue.erp.datasource.mappers.MaterialPropertyMapper;
import com.xue.erp.datasource.mappers.MaterialPropertyMapperEx;
import com.xue.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MaterialPropertyService {
    private Logger logger = LoggerFactory.getLogger(MaterialPropertyService.class);

    @Resource
    private MaterialPropertyMapper materialPropertyMapper;

    @Resource
    private MaterialPropertyMapperEx materialPropertyMapperEx;

    public MaterialProperty getMaterialProperty(long id) {
        return materialPropertyMapper.selectByPrimaryKey(id);
    }

    public List<MaterialProperty> getMaterialProperty() {
        MaterialPropertyExample example = new MaterialPropertyExample();
        return materialPropertyMapper.selectByExample(example);
    }
    public List<MaterialProperty> select(String name, int offset, int rows) {
        return materialPropertyMapperEx.selectByConditionMaterialProperty(name, offset, rows);
    }

    public Long countMaterialProperty(String name) {
        return materialPropertyMapperEx.countsByMaterialProperty(name);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMaterialProperty(String beanJson, HttpServletRequest request) {
        MaterialProperty materialProperty = JSONObject.parseObject(beanJson, MaterialProperty.class);
        return materialPropertyMapper.insertSelective(materialProperty);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMaterialProperty(String beanJson, Long id) {
        MaterialProperty materialProperty = JSONObject.parseObject(beanJson, MaterialProperty.class);
        materialProperty.setId(id);
        return materialPropertyMapper.updateByPrimaryKeySelective(materialProperty);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMaterialProperty(Long id) {
        return materialPropertyMapper.deleteByPrimaryKey(id);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialProperty(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        MaterialPropertyExample example = new MaterialPropertyExample();
        example.createCriteria().andIdIn(idList);
        return materialPropertyMapper.deleteByExample(example);
    }

    public int checkIsNameExist(Long id, String name) {
        return 0;
    }
}
