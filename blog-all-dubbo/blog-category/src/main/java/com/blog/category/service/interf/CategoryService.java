package com.blog.category.service.interf;

import java.util.Map;

/**
 * Created by Mario on 2015/10/1.
 */
public interface CategoryService {
    /**
     * 添加类别
     * @param categoryName
     * @return
     */
    Map<String,Object> saveCategory(String categoryName);

    /**
     * 查询所有类别列表
     * @return
     */
    Map<String,Object> queryCategory();

    /**
     * 根据id查询类别信息
     * @param categoryId
     * @return
     */
    Map<String,Object> queryCategoryById(String categoryId);
}
