package com.itheima.service;

import com.itheima.pojo.Category;

import java.util.List;

/**
 * @author Kieran_Chase
 * @project big-event
 * @date 2026/1/16
 */
public interface CategoryService {
    //新增分类
    void add(Category category);

    //列表查询
    List<Category> list();

    //根据id查询分类信息
    Category findById(Integer id);

    //更新
    void update(Category category);
}
