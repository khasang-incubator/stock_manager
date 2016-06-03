package io.khasang.stockmanager.dao;


import io.khasang.stockmanager.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao {
    void save(Product product);
    void delete(Product product);

    void deleteAll();
    List<Product> getAll();

    Product getById(int id);
}
