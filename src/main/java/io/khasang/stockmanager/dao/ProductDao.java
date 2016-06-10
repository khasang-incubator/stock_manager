package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Product;

import java.util.List;

public interface ProductDAO {
    void save(Product product);
    void delete(Product product);

    void deleteAll();
    List<Product> getAll();

    Product getById(Long id);
}
