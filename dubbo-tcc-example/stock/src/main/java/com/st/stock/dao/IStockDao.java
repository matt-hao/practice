package com.st.stock.dao;

import com.st.stock.domain.Stock;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mario on 2016/10/13.
 */
public interface IStockDao extends CrudRepository<Stock, Long> {
    Stock findByProductId(Long productId);
}
