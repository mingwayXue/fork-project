package com.xue.xblog.business.service;


import com.xue.xblog.business.vo.ArticleLoveConditionVO;
import com.xue.xblog.framework.object.AbstractService;
import com.xue.xblog.business.entity.ArticleLove;
import com.github.pagehelper.PageInfo;

/**
 * 文章点赞
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface BizArticleLoveService extends AbstractService<ArticleLove, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ArticleLove> findPageBreakByCondition(ArticleLoveConditionVO vo);
}
