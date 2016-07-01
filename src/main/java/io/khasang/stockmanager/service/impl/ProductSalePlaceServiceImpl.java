package io.khasang.stockmanager.service.impl;

import io.khasang.stockmanager.dao.ProductSalePlaceDAO;
import io.khasang.stockmanager.entity.ProductSalePlace;
import io.khasang.stockmanager.service.ProductSalePlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductSalePlaceServiceImpl implements ProductSalePlaceService {
    @Autowired
    ProductSalePlaceDAO dao;

    @Transactional
    @Override
    public List<ProductSalePlace> getAllByProductId(Long productId) {
        return dao.getAllByProductId(productId);
    }

    @Transactional
    @Override
    public void saveProductSalePlace(ProductSalePlace productSalePlace) {
        if (productSalePlace == null)
            return;
        dao.save(productSalePlace);
    }

    @Transactional
    @Override
    public void delete(ProductSalePlace productSalePlace) {
        if (productSalePlace == null)
            return;
        dao.delete(productSalePlace);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        ProductSalePlace productSalePlace = new ProductSalePlace();
        productSalePlace.setId(id);
        delete(productSalePlace);
    }

}
