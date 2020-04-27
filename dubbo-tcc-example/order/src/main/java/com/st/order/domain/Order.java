package com.st.order.domain;


import javax.persistence.*;

/**
 * Created by Mario on 2016/10/13.
 */
@Entity
@Table(name = "dubbo_order")
public class Order {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
