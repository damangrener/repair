package com.wtf.article.entity.vo;

import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/5/19 18:54
 */
@Data
public class ArticleVO {
    private Integer id;

    private String title;

    private Integer category;

    private String author;

    private String imgPath;

    private String createTime;

    private String updateTime;

    private Integer checkPass;

    private String authorAccount;

    private String content;

    private String categoryName;
}
