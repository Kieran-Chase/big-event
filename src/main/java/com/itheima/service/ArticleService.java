package com.itheima.service;

import com.itheima.pojo.Article;
import com.itheima.pojo.PageBean;

/**
 * @author Kieran_Chase
 * @project big-event
 * @date 2026/1/16
 */
public interface ArticleService {
    //新增
    void add(Article article);

    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
