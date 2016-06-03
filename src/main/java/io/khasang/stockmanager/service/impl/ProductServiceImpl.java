package io.khasang.stockmanager.service.impl;

import io.khasang.stockmanager.dao.ProductDao;
import io.khasang.stockmanager.entity.Product;
import io.khasang.stockmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Transactional
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Transactional
    public List<Product> listProduct() {
        return productDao.listProduct();
    }

    @Transactional
    public void removeProduct(Integer id) {
        productDao.removeProduct(id);
    }
}
