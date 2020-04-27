package com.blog.bbs.dao.impl;

import com.blog.bbs.dao.interf.ItemDao;
import com.blog.bbs.vo.ItemVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2015/10/8.
 */
@Repository
public class ItemDaoImpl extends BaseDao implements ItemDao {
    private static final Logger logger = Logger.getLogger(ItemDaoImpl.class);

    public List<ItemVO> queryItemByCategoryId(String categoryId) {
        List<ItemVO> list = new ArrayList<ItemVO>();
        try {
            list = this.getSqlSession().selectList("com.mario.blog.mapper.ItemMapper.queryItemByCategoryId", categoryId);
        } catch (Exception e) {
            logger.error("根据categoryId查询item异常[dao]", e);
        }
        return list;
    }

    public ItemVO queryItemById(int itemId) {
        ItemVO vo = null;
        try {
            vo = this.getSqlSession().selectOne("com.mario.blog.mapper.ItemMapper.queryItemInfoById", itemId);
        } catch (Exception e) {
            logger.error("根据id查询item异常[dao]", e);
        }
        return vo;
    }
}
