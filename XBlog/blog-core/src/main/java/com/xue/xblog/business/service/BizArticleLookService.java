package com.xue.xblog.business.service;


import com.xue.xblog.business.vo.ArticleLookConditionVO;
import com.xue.xblog.framework.object.AbstractService;
import com.xue.xblog.business.entity.ArticleLook;
import com.github.pagehelper.PageInfo;

/**
 * 文章浏览记录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface BizArticleLookService extends AbstractService<ArticleLook, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ArticleLook> findPageBreakByCondition(ArticleLookConditionVO vo);
}
