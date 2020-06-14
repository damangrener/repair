package com.wtf.article.service;

import com.github.pagehelper.PageInfo;
import com.wtf.article.entity.po.ArticlePO;
import com.wtf.article.entity.user.User;
import com.wtf.article.entity.vo.ArticleVO;

import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/3/24 13:54
 */
public interface ArticleService {

    Integer insertArticle(ArticlePO articlePO, User user);

    Integer checkArticle(ArticlePO articlePO,Integer check);

    PageInfo<ArticleVO> selectALLArticle(Integer category);

    ArticleVO selectDetail(Integer id);
}
