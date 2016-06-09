package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Product;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import java.util.List;

/**
 *
 * @author ShtykovPavel
 */
public interface IProjectProductService {

    public void addProjectProduct(ProjectProduct projectProduct);

    public void deleteProjectProduct(Long projectProductId);

    public void updateStateProjectProduct(ProjectProduct projectProduct);

    public List<ProjectProduct> getProjectProducts();

    public List<Project> getProject();

    public List<Product> getProduct();

}
