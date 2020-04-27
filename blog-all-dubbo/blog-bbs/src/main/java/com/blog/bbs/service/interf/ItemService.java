package com.blog.bbs.service.interf;

import java.util.Map;

/**
 * Created by Mario on 2015/9/10.
 */
public interface ItemService {
    public Map<String,Object> queryItemByCategoryId(String categoryId);

    public Map<String,Object> queryItemInfoById(int itemId);
}
