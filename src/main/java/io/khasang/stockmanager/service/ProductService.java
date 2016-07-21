package io.khasang.stockmanager.service;

import io.khasang.stockmanager.entity.Product;

import java.util.List;


public interface ProductService {

    void saveProduct(Product product);

    void delete(Product product);

    void delete(Long id);

    List<Product> getAllByUser(Long userId);

    Product getById(Long id);

}
