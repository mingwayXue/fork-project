package com.xue.erp.service.systemConfig;

import com.xue.erp.service.ICommonQuery;
import com.xue.erp.utils.QueryUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "systemConfig_component")
@SystemConfigResource
public class SystemConfigComponent implements ICommonQuery {

    @Resource
    private SystemConfigService systemConfigService;

    @Override
    public Object selectOne(String condition) {
        return null;
    }

    @Override
    public List<?> select(Map<String, String> map) {
        return getSystemConfigList(map);
    }

    private List<?> getSystemConfigList(Map<String, String> map) {
        String order = QueryUtils.order(map);
        return systemConfigService.select(QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) {
        return systemConfigService.countSystemConfig();
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) {
        return systemConfigService.insertSystemConfig(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id) {
        return systemConfigService.updateSystemConfig(beanJson, id);
    }

    @Override
    public int delete(Long id) {
        return systemConfigService.deleteSystemConfig(id);
    }

    @Override
    public int batchDelete(String ids) {
        return systemConfigService.batchDeleteSystemConfig(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name) {
        return systemConfigService.checkIsNameExist(id, name);
    }

}
