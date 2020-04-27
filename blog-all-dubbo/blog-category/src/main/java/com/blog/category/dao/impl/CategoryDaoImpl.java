package com.blog.category.dao.impl;

import com.blog.category.dao.interf.CategoryDao;
import com.blog.category.vo.CategoryVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2015/10/1.
 */
@Repository
public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    private static final Logger logger = Logger.getLogger(CategoryDaoImpl.class);

    public void saveCategory(CategoryVO categoryVO) {
        try {
            this.getSqlSession().insert("com.mario.blog.mapper.CategoryMapper.saveCategory", categoryVO);
        } catch (Exception e) {
            logger.error("添加类别异常[dao]", e);
        }
    }

    public List<CategoryVO> queryCategory() {
        List<CategoryVO> list = new ArrayList<CategoryVO>();
        try{
            list = this.getSqlSession().selectList("com.mario.blog.mapper.CategoryMapper.queryCategory");
        }catch (Exception e ){
            logger.error("获取类别列表异常[dao]",e);
        }
        return list;
    }

    public CategoryVO queryCategoryById(String categoryId) {
        CategoryVO categoryVO = null;
        try{
            categoryVO = this.getSqlSession().selectOne("com.mario.blog.mapper.CategoryMapper.queryCategoryById",categoryId);
        }catch (Exception e){
            logger.error("根据categoryId获取类别信息[dao]",e);
        }
        return categoryVO;
    }
}
