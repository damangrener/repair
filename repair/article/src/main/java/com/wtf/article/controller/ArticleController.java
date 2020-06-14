package com.wtf.article.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wtf.article.constant.ResponseCode;
import com.wtf.article.entity.po.ArticlePO;
import com.wtf.article.entity.user.User;
import com.wtf.article.entity.vo.ArticleVO;
import com.wtf.article.service.ArticleService;
import com.wtf.article.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wangtengfei
 * @since 2020/3/23 15:01
 */
@RestController
@RequestMapping("api/article")
@Api("用户管理")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "插入文章", notes = "插入文章")
    @PostMapping("insertArticle")
    public ResponseEntity<Integer> insertArticle(ArticlePO articlePO,
                                                 @ApiIgnore User user) {
        int a = articleService.insertArticle(articlePO, user);
        if (a == 1) {
            return ResponseEntity.success(a);
        } else {
            return ResponseEntity.failure(ResponseCode.insert_err);
        }
    }

    @ApiOperation(value = "文章审核", notes = "文章审核")
    @PostMapping("checkArticle")
    public ResponseEntity<Integer> checkArticle(ArticlePO articlePO,
                                                @RequestParam(value = "check") Integer check) {
        return ResponseEntity.success(articleService.checkArticle(articlePO, check));
    }

    @ApiOperation(value = "查询文章", notes = "查询文章")
    @GetMapping("selectALLArticle")
    public ResponseEntity<PageInfo<ArticleVO>> selectALLArticle(@RequestParam(value = "category") Integer category,
                                                                @RequestParam(value = "pageNum") Integer pageNum,
                                                                @RequestParam(value = "pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ResponseEntity.success(articleService.selectALLArticle(category));
    }

    @ApiOperation(value = "获取文章详情", notes = "获取文章详情")
    @GetMapping("selectDetail")
    public ResponseEntity<ArticleVO> selectDetail(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.success(articleService.selectDetail(id));
    }


}
