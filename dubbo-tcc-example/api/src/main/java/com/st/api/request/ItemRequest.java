package com.st.api.request;

import java.io.Serializable;

/**
 * Created by Mario on 2016/10/13.
 */
public class ItemRequest implements Serializable {

    private static final long serialVersionUID = -7792755736493677906L;

    private Long id;

    private Long productId;

    private Long orderId;

    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
