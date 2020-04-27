package com.st.item.domain;


import com.st.api.request.ItemRequest;
import com.st.api.respose.ItemResponse;

import javax.persistence.*;

/**
 * Created by Mario on 2016/10/13.
 */
@Entity
@Table(name = "dubbo_item")
public class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * 订单号
     */
    private Long orderId;

    /**
     * 产品数量
     */
    private Integer productQuantity;

    public Item() {
    }

    public Item(ItemRequest itemRequest) {
        this.orderId = itemRequest.getOrderId();
        this.productQuantity = itemRequest.getQuantity();
    }

    public Long getId() {
        return this.id;
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

    public ItemResponse as() {
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setId(this.id);
        itemResponse.setOrderId(this.orderId);
        itemResponse.setProductQuantity(this.productQuantity);
        return itemResponse;
    }
}
