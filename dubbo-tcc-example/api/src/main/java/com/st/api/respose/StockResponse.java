package com.st.api.respose;

import java.io.Serializable;

/**
 * Created by Mario on 2016/10/13.
 */
public class StockResponse implements Serializable {

    private static final long serialVersionUID = 5489739803337361001L;
    private Long id;

    private Long productId;

    private Integer quantity;

    private Boolean isConsume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getConsume() {
        return isConsume;
    }

    public void setConsume(Boolean consume) {
        isConsume = consume;
    }
}
