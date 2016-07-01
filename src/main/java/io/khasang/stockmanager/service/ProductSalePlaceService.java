package io.khasang.stockmanager.service;

import io.khasang.stockmanager.entity.ProductSalePlace;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductSalePlaceService {
    List<ProductSalePlace> getAllByProductId(Long productId);

    void saveProductSalePlace(ProductSalePlace productSalePlace);

    void delete(ProductSalePlace productSalePlace);

    void delete(Long id);

}
