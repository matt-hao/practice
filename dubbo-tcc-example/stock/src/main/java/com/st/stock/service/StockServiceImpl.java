package com.st.stock.service;

import com.st.api.StockService;
import com.st.api.request.ItemRequest;
import com.st.api.respose.StockResponse;
import com.st.stock.dao.IStockDao;
import com.st.stock.domain.Stock;
import org.mengyun.tcctransaction.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by Mario on 2016/10/13.
 */
@Service("stockService")
public class StockServiceImpl implements StockService {

    @Autowired
    private IStockDao stockDao;

    @Override
    @Transactional
    @Compensable(confirmMethod = "confirmFindAndSubStock", cancelMethod = "cancelFindAndSubStock")
    public StockResponse findAndSubStock(TransactionContext transactionContext, ItemRequest itemRequest) {
        Objects.requireNonNull(itemRequest);
        Stock stock = stockDao.findByProductId(itemRequest.getProductId());
        Objects.requireNonNull(stock);
        if (stock.getQuantity() == 0 || stock.getQuantity() < itemRequest.getQuantity())
            throw new IllegalArgumentException("stock not enough");
        stock.setQuantity(stock.getQuantity() - itemRequest.getQuantity());
        stock.setConsume(true);
        return stockDao.save(stock).as();
    }

    public void confirmFindAndSubStock(TransactionContext transactionContext, ItemRequest itemRequest) {
        System.out.println("Stock confirm...");
        Stock stock = findAndCheck(itemRequest);
        stock.setConsume(false);//流程确认完,将消费置为false,便于下次消费可用
        stockDao.save(stock);
    }

    public void cancelFindAndSubStock(TransactionContext transactionContext, ItemRequest itemRequest) {
        System.out.println("Stock cancel...");
        Stock stock = findAndCheck(itemRequest);
        if (stock.isConsume()) {
            stock.setQuantity(stock.getQuantity() + itemRequest.getQuantity());
            stock.setConsume(false);
            stockDao.save(stock);
        }
    }

    private Stock findAndCheck(ItemRequest itemRequest) {
        Stock stock = stockDao.findByProductId(itemRequest.getProductId() == null ? 0 : itemRequest.getProductId());
        Objects.requireNonNull(stock);
        return stock;
    }
}
