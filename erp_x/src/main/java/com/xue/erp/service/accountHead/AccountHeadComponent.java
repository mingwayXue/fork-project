package com.xue.erp.service.accountHead;

import com.xue.erp.service.ICommonQuery;
import com.xue.erp.utils.Constants;
import com.xue.erp.utils.QueryUtils;
import com.xue.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "accountHead_component")
@AccountHeadResource
public class AccountHeadComponent implements ICommonQuery {

    @Resource
    private AccountHeadService accountHeadService;

    @Override
    public Object selectOne(String condition) {
        return null;
    }

    @Override
    public List<?> select(Map<String, String> map) {
        return getAccountHeadList(map);
    }

    private List<?> getAccountHeadList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String billNo = StringUtil.getInfo(search, "billNo");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String order = QueryUtils.order(map);
        return accountHeadService.select(type, billNo, beginTime, endTime, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String billNo = StringUtil.getInfo(search, "billNo");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        return accountHeadService.countAccountHead(type, billNo, beginTime, endTime);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) {
        return accountHeadService.insertAccountHead(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id) {
        return accountHeadService.updateAccountHead(beanJson, id);
    }

    @Override
    public int delete(Long id) {
        return accountHeadService.deleteAccountHead(id);
    }

    @Override
    public int batchDelete(String ids) {
        return accountHeadService.batchDeleteAccountHead(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name) {
        return accountHeadService.checkIsNameExist(id, name);
    }

}
