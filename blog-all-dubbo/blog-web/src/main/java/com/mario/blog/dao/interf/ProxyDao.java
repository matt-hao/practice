package com.mario.blog.dao.interf;

import java.util.Map;

/**
 * Created by Mario on 2015/10/9.
 */
public interface ProxyDao {
    String userDaoProxy(Map<String,Object> reqMap);

    String categoryDaoProxy(Map<String,Object> reqMap);

    String bbsDaoProxy(Map<String,Object> reqMap);

}
