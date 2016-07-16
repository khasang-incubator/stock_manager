package io.khasang.stockmanager.service.impl;


import io.khasang.stockmanager.dao.ProductDAO;
import io.khasang.stockmanager.entity.Product;
import io.khasang.stockmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO dao;

    @Transactional
    @Override
    public void saveProduct(Product product) {
        if (product == null)
            return;
        dao.save(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        if (product == null)
            return;
        dao.delete(product);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Product product = new Product();
        product.setId(id);
        delete(product);
    }

    @Transactional
    @Override
    public List<Product> getAll(Long userId) {
        return dao.getAll(userId);
    }

    @Transactional
    @Override
    public Product getById(Long id) {
        return dao.getById(id);
    }
}
