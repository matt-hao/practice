package com.st.api;

import com.st.api.request.ItemRequest;
import com.st.api.respose.StockResponse;
import org.mengyun.tcctransaction.api.TransactionContext;

/**
 * Created by Mario on 2016/10/13.
 */
public interface StockService {
    StockResponse findAndSubStock(TransactionContext transactionContext, ItemRequest itemRequest);
}
