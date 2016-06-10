package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProjectProductService;
import io.khasang.stockmanager.entity.Product;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {

    @Autowired
    private ProjectProductDAOImpl projectProductDaoImplImpl;

    @Override
    public void addProjectProduct(ProjectProduct projectProduct) {
        projectProductDaoImplImpl.addProjectProduct(projectProduct);
    }

    @Override
    public void deleteProjectProduct(Long projectProductId) {
        projectProductDaoImplImpl.deleteProjectProduct(projectProductId);
    }

    @Override
    public void updateStateProjectProduct(ProjectProduct projectProduct) {
        projectProductDaoImplImpl.updateStateProjectProduct(projectProduct);
    }

    @Override
    public List<ProjectProduct> getProjectProducts() {
        return projectProductDaoImplImpl.getProjectProducts();
    }

    @Override
    public List<Project> getProject() {
        return projectProductDaoImplImpl.getProject();
    }

    @Override
    public List<Product> getProduct() {
        return projectProductDaoImplImpl.getProduct();
    }

    @Override
    public void truncate() {
        projectProductDaoImplImpl.truncate();
    }

}
