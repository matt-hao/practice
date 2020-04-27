package com.st.item.service;

import com.st.api.ItemService;
import com.st.api.StockService;
import com.st.api.request.ItemRequest;
import com.st.api.respose.ItemResponse;
import com.st.item.dao.IItemDao;
import com.st.item.domain.Item;
import org.mengyun.tcctransaction.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by Mario on 2016/10/13.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private IItemDao iItemDao;

    @Autowired
    private StockService stockService;

    @Override
    @Compensable(confirmMethod = "confirmSaveItem", cancelMethod = "cancelSaveItem")
    public ItemResponse saveItem(TransactionContext transactionContext, ItemRequest itemRequest) throws IllegalAccessException {
        System.out.println("save Item...");
        Objects.requireNonNull(itemRequest);
        stockService.findAndSubStock(null, itemRequest);
        ItemResponse itemResponse = iItemDao.save(new Item(itemRequest)).as();
        itemRequest.setId(itemResponse.getId());
        throw new IllegalAccessException("whatever exception is");
//        return itemResponse;
    }

    public void confirmSaveItem(TransactionContext transactionContext, ItemRequest itemRequest) {
        System.out.println("saveItem confirm...");
    }

    public void cancelSaveItem(TransactionContext transactionContext, ItemRequest itemRequest) {
        System.out.println("saveItem cancel...");
        Item item = iItemDao.findOne(itemRequest.getId() == null ? 0 : itemRequest.getId());
        if (item != null) {
            iItemDao.delete(item);
        }
    }
}
