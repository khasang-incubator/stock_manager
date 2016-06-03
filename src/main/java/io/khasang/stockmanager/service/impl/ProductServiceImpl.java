package io.khasang.stockmanager.service.impl;


import io.khasang.stockmanager.dao.ProductDao;
import io.khasang.stockmanager.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao dao;

    @Override
    public void persistProduct(Product product) {
        if (product == null)
            return;
        dao.save(product);
    }

    @Override
    public void delete(Product product) {
        if (product == null)
            return;
        dao.delete(product);
    }

    @Override
    public List<Product> getAll() {
        return dao.getAll();
    }

    @Override
    public Product getById(int id) {
        return dao.getById(id);
    }
}
