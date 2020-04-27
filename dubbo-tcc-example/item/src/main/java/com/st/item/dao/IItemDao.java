package com.st.item.dao;

import com.st.item.domain.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mario on 2016/10/13.
 */
public interface IItemDao extends CrudRepository<Item, Long> {
}
