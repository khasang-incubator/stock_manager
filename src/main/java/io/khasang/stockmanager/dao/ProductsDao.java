package io.khasang.stockmanager.dao;


import io.khasang.stockmanager.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductsDao {
    void persist(Product product);
    void delete(Product product);
    List<Product> getAll();
}
