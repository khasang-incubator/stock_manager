package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProductsDao;
import io.khasang.stockmanager.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductsDaoImpl implements ProductsDao {
    @Override
    public void persist(Product product) {

    }

    @Override
    public List<Product> getAll() {
        return Collections.emptyList();
    }
}
