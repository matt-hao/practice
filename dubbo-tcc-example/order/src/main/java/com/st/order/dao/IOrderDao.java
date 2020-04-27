package com.st.order.dao;

import com.st.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mario on 2016/10/13.
 */
public interface IOrderDao extends CrudRepository<Order, Long> {
}
