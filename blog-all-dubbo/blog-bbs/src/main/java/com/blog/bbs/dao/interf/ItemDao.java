package com.blog.bbs.dao.interf;

import com.blog.bbs.vo.ItemVO;

import java.util.List;

/**
 * Created by Mario on 2015/10/8.
 */
public interface ItemDao {
    List<ItemVO> queryItemByCategoryId(String categoryId);

    ItemVO queryItemById(int itemId);
}
