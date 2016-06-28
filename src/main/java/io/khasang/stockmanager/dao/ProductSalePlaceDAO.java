package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.ProductSalePlace;
import java.util.List;

public interface ProductSalePlaceDAO {
    List<ProductSalePlace> getAll();

    List<ProductSalePlace> getProductSalePlacesByProductId(Long id);

    void delete(ProductSalePlace productSalePlace);

    void add(ProductSalePlace productSalePlace);

    void saveOrUpdate(ProductSalePlace productSalePlace);
}
