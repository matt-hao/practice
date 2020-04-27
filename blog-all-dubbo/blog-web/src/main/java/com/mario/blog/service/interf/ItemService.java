package com.mario.blog.service.interf;

import java.util.Map;

/**
 * Created by Mario on 2015/9/10.
 */
public interface ItemService {
    public Map<String,Object> listItemByCategoryId(String categoryId);

    public Map<String,Object> getItemInfoById(int itemId);
}
