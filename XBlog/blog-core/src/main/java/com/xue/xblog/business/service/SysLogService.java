package com.xue.xblog.business.service;


import com.github.pagehelper.PageInfo;
import com.xue.xblog.business.entity.Log;
import com.xue.xblog.business.vo.LogConditionVO;
import com.xue.xblog.framework.object.AbstractService;

/**
 * @author yadong.zhang email:yadong.zhang0415(a)gmail.com
 * @version 1.0
 * @date 2018/01/09 17:40
 * @since 1.0
 */
public interface SysLogService extends AbstractService<Log, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<Log> findPageBreakByCondition(LogConditionVO vo);
}
