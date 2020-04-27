package com.st.order.service;

import com.st.order.pojo.OrderRequest;
import com.st.order.pojo.OrderResponse;

import java.io.IOException;

/**
 * Created by Mario on 2016/10/13.
 */
public interface OrderService {
    OrderResponse saveOrder(OrderRequest orderRequest);
}
