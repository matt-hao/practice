package com.st.api;

import com.st.api.request.ItemRequest;
import com.st.api.respose.ItemResponse;
import org.mengyun.tcctransaction.api.TransactionContext;

/**
 * Created by Mario on 2016/10/13.
 */
public interface ItemService {
    ItemResponse saveItem(TransactionContext transactionContext, ItemRequest itemRequest) throws IllegalAccessException;
}
