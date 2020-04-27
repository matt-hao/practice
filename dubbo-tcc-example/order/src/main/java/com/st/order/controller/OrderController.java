package com.st.order.controller;

import com.st.api.request.ItemRequest;
import com.st.order.pojo.OrderRequest;
import com.st.order.service.OrderService;
import com.st.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mario on 2016/10/13.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping(value = "addOrder", method = RequestMethod.GET)
    @ResponseBody
    public String addOrder() throws IllegalAccessException {
        orderService.saveOrder(builderOrder());
        return "success";
    }

    private OrderRequest builderOrder() {
        OrderRequest orderRequest = new OrderRequest();
        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setProductId(5L);
        itemRequest.setQuantity(5);
        orderRequest.setItemRequest(itemRequest);
        return orderRequest;
    }
}
