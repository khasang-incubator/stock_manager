package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProjectProductService;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {

    @Autowired
    private ProjectProductDAOImpl projectProductDaoImpl;

    @Override
    public void addProjectProduct(ProjectProduct projectProduct) {
        projectProductDaoImpl.addProjectProduct(projectProduct);
    }

    @Override
    public void deleteProjectProduct(Long projectProductId) {
        projectProductDaoImpl.deleteProjectProduct(projectProductId);
    }

    @Override
    public void updateStateProjectProduct(ProjectProduct projectProduct) {
        projectProductDaoImpl.updateStateProjectProduct(projectProduct);
    }

    @Override
    public List<ProjectProduct> getProjectProducts() {
        return projectProductDaoImpl.getProjectProducts();
    }

    @Override
    public List<Project> getProjects() {
        return projectProductDaoImpl.getProjects();
    }

    @Override
    public void truncate() {
        projectProductDaoImpl.truncate();
    }

}
