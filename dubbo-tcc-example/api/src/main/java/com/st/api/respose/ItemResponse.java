package com.st.api.respose;

import java.io.Serializable;

/**
 * Created by Mario on 2016/10/13.
 */
public class ItemResponse implements Serializable {
    private static final long serialVersionUID = -5586224810424319087L;
    private Long id;

    private Long orderId;

    private Integer productQuantity;

    private boolean isConsume;

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

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public boolean isConsume() {
        return isConsume;
    }

    public void setConsume(boolean consume) {
        isConsume = consume;
    }
}
