package com.xue.xblog.business.service;


import com.xue.xblog.business.entity.UpdateRecorde;
import com.xue.xblog.business.vo.UpdateRecordeConditionVO;
import com.xue.xblog.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

/**
 * 更新记录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface SysUpdateRecordeService extends AbstractService<UpdateRecorde, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<UpdateRecorde> findPageBreakByCondition(UpdateRecordeConditionVO vo);
}
