package com.xue.erp.service.functions;

import com.alibaba.fastjson.JSONObject;
import com.xue.erp.datasource.entities.Functions;
import com.xue.erp.datasource.entities.FunctionsExample;
import com.xue.erp.datasource.mappers.FunctionsMapper;
import com.xue.erp.datasource.mappers.FunctionsMapperEx;
import com.xue.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class FunctionsService {
    private Logger logger = LoggerFactory.getLogger(FunctionsService.class);

    @Resource
    private FunctionsMapper functionsMapper;

    @Resource
    private FunctionsMapperEx functionsMapperEx;

    public Functions getFunctions(long id) {
        return functionsMapper.selectByPrimaryKey(id);
    }

    public List<Functions> getFunctions() {
        FunctionsExample example = new FunctionsExample();
        return functionsMapper.selectByExample(example);
    }

    public List<Functions> select(String name, String type, int offset, int rows) {
        return functionsMapperEx.selectByConditionFunctions(name, type, offset, rows);
    }

    public Long countFunctions(String name, String type) {
        return functionsMapperEx.countsByFunctions(name, type);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertFunctions(String beanJson, HttpServletRequest request) {
        Functions depot = JSONObject.parseObject(beanJson, Functions.class);
        return functionsMapper.insertSelective(depot);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateFunctions(String beanJson, Long id) {
        Functions depot = JSONObject.parseObject(beanJson, Functions.class);
        depot.setId(id);
        return functionsMapper.updateByPrimaryKeySelective(depot);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteFunctions(Long id) {
        return functionsMapper.deleteByPrimaryKey(id);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteFunctions(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andIdIn(idList);
        return functionsMapper.deleteByExample(example);
    }

    public int checkIsNameExist(Long id, String name) {
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name);
        List<Functions> list = functionsMapper.selectByExample(example);
        return list.size();
    }

    public List<Functions> getRoleFunctions(String pNumber) {
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andEnabledEqualTo(true).andPnumberEqualTo(pNumber);
        example.setOrderByClause("Sort");
        List<Functions> list = functionsMapper.selectByExample(example);
        return list;
    }

    public List<Functions> findRoleFunctions(String pnumber){
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andEnabledEqualTo(true).andPnumberEqualTo(pnumber);
        example.setOrderByClause("Sort");
        List<Functions> list = functionsMapper.selectByExample(example);
        return list;
    }

    public List<Functions> findByIds(String functionsIds){
        List<Long> idList = StringUtil.strToLongList(functionsIds);
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andEnabledEqualTo(true).andIdIn(idList);
        example.setOrderByClause("Sort asc");
        List<Functions> list = functionsMapper.selectByExample(example);
        return list;
    }
}
