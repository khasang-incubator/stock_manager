package service;


import io.khasang.stockmanager.entity.Product;

import java.util.List;

public interface ProductService {

    void persistProduct(Product product);

    void delete(Product product);

    List<Product> getAll();

    Product getById(int id);

}
