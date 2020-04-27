package com.st.order.service;

import com.st.api.ItemService;
import com.st.order.dao.IOrderDao;
import com.st.order.domain.Order;
import com.st.order.pojo.OrderRequest;
import com.st.order.pojo.OrderResponse;
import org.mengyun.tcctransaction.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by Mario on 2016/10/13.
 */
@Service
public class OrderServiceImpl {

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private ItemService itemService;

    @Compensable(confirmMethod = "confirmSaveOrder", cancelMethod = "cancelSaveOrder")
    public OrderResponse saveOrder(OrderRequest orderRequest) throws IllegalAccessException {
        System.out.println("save order...");
        Objects.requireNonNull(orderRequest);

        //save the order
        Order o = orderDao.save(new Order());
        orderRequest.getItemRequest().setOrderId(o.getId());

        //save the Item
        itemService.saveItem(null, orderRequest.getItemRequest());
        return new OrderResponse();
    }

    public void confirmSaveOrder(OrderRequest orderRequest) throws IOException {
        System.out.println("confirmSaveOrder....");
    }

    public void cancelSaveOrder(OrderRequest orderRequest) throws IOException {
        System.out.println("cancelSaveOrder....");
        Order order = orderDao.findOne(orderRequest.getItemRequest().getOrderId() == null ? 0 : orderRequest.getItemRequest().getOrderId());
        if (order != null)
            orderDao.delete(order);
    }
}
