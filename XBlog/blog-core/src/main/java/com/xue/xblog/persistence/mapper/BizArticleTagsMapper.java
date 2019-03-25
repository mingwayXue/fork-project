package com.xue.xblog.persistence.mapper;

import com.xue.xblog.business.vo.ArticleTagsConditionVO;
import com.xue.xblog.persistence.beans.BizArticleTags;
import com.xue.xblog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @website https://www.zhyd.me
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Repository
public interface BizArticleTagsMapper extends BaseMapper<BizArticleTags>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizArticleTags> findPageBreakByCondition(ArticleTagsConditionVO vo);
}
