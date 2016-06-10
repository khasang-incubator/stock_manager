package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Product;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import java.util.List;

public interface IProjectProductService {

    void addProjectProduct(ProjectProduct projectProduct);

    void deleteProjectProduct(Long projectProductId);

    void updateStateProjectProduct(ProjectProduct projectProduct);

    List<ProjectProduct> getProjectProducts();

    List<Project> getProject();

    List<Product> getProduct();

    void truncate();
}
