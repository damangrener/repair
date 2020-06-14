package com.wtf.article.entity.po;

import lombok.Data;

import java.util.Date;
@Data
public class ArticlePO {
    private Integer id;

    private String title;

    private Integer category;

    private String author;

    private String imgPath;

    private Date createTime;

    private Date updateTime;

    private Integer checkPass;

    private String authorAccount;

    private String content;

    private String categoryName;

}