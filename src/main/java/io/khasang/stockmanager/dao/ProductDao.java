package io.khasang.stockmanager.dao;


import io.khasang.stockmanager.entity.Product;

import java.util.List;

public interface ProductDao {
    void persist(Product product);
    void delete(Product product);
    List<Product> getAll();

    Product getById(int id);

    public void addProduct(Product contact);

    public List<Product> listProduct();

    public void removeProduct(Integer id);
}
