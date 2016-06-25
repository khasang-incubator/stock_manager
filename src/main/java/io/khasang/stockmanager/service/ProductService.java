package io.khasang.stockmanager.service;

import io.khasang.stockmanager.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    void saveProduct(Product product);

    void delete(Product product);

    void delete(Long id);

    List<Product> getAll();

    Product getById(Long id);

}
