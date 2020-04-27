package com.st.stock.domain;

import com.st.api.respose.StockResponse;

import javax.persistence.*;


/**
 * Created by Mario on 2016/10/13.
 */
@Entity
@Table(name = "dubbo_stock")
public class Stock {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * 产品id
     */
    @Column
    private Long productId;

    /**
     * 产品数量
     */
    @Column
    private Integer quantity;

    /**
     * 是否消费
     */
    @Column
    private boolean isConsume = false;

    public Long getId() {
        return this.id;
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

    public boolean isConsume() {
        return isConsume;
    }

    public void setConsume(boolean consume) {
        isConsume = consume;
    }

    public StockResponse as() {
        StockResponse stockResponse = new StockResponse();
        stockResponse.setId(this.id);
        stockResponse.setProductId(this.productId);
        stockResponse.setQuantity(this.quantity);
        return stockResponse;
    }
}
