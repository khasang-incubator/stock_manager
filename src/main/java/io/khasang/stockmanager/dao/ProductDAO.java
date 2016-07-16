package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Product;

import java.util.List;

/**
* Prod DAO
* */
public interface ProductDAO {
    void save(Product product);
    void delete(Product product);

    void deleteAll();
    List<Product> getAll(Long userId);

    Product getById(Long id);
}
