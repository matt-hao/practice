package com.st.order.pojo;


import com.st.api.request.ItemRequest;

import java.io.Serializable;

/**
 * Created by Mario on 2016/10/13.
 */
public class OrderRequest implements Serializable{

    private static final long serialVersionUID = -4838535541353110352L;
    private ItemRequest itemRequest;

    public ItemRequest getItemRequest() {
        return itemRequest;
    }

    public void setItemRequest(ItemRequest itemRequest) {
        this.itemRequest = itemRequest;
    }
}
