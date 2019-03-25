package com.xue.xblog.business.service;


import com.github.pagehelper.PageInfo;
import com.xue.xblog.business.entity.ArticleTags;
import com.xue.xblog.business.vo.ArticleTagsConditionVO;
import com.xue.xblog.framework.object.AbstractService;

/**
 * 文章标签
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface BizArticleTagsService extends AbstractService<ArticleTags, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ArticleTags> findPageBreakByCondition(ArticleTagsConditionVO vo);

    /**
     * 通过文章id删除文章-标签关联数据
     *
     * @param articleId
     * @return
     */
    int removeByArticleId(Long articleId);

    /**
     * 批量添加
     *
     * @param tagIds
     * @param articleId
     */
    void insertList(Long[] tagIds, Long articleId);
}
