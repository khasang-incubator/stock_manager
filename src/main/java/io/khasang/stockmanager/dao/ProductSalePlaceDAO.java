package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.ProductSalePlace;
import java.util.List;

public interface ProductSalePlaceDAO {
    List<ProductSalePlace> getAllByProductId(Long productId);

    void save(ProductSalePlace productSalePlace);

    void delete(ProductSalePlace productSalePlace);
}
