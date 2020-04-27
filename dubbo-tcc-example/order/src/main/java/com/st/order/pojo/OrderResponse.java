package com.st.order.pojo;

import com.st.api.respose.ItemResponse;

/**
 * Created by Mario on 2016/10/13.
 */
public class OrderResponse {
    private Long orderId;
    private ItemResponse itemResponse;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ItemResponse getItemResponse() {
        return itemResponse;
    }

    public void setItemResponse(ItemResponse itemResponse) {
        this.itemResponse = itemResponse;
    }
}
