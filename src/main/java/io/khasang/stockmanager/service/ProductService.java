package io.khasang.stockmanager.service;

import io.khasang.stockmanager.entity.Product;

import java.util.List;

public interface ProductService {

    public void addProduct(Product contact);

    public List<Product> listProduct();

    public void removeProduct(Integer id);
}
