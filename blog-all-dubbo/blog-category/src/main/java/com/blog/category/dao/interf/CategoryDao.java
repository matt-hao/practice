package com.blog.category.dao.interf;


import com.blog.category.vo.CategoryVO;

import java.util.List;

/**
 * Created by Mario on 2015/10/1.
 */
public interface CategoryDao {
    void saveCategory(CategoryVO categoryVO);

    List<CategoryVO> queryCategory();

    CategoryVO queryCategoryById(String categoryId);
}
