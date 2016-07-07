package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProjectService;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAOImpl projectDaoImpl;

//    @Transactional
    @Override
    public void addProject(Project project) {
        projectDaoImpl.addProject(project);
    }

//    @Transactional
    @Override
    public void deleteProject(Long projectId) {
        projectDaoImpl.deleteProject(projectId);
    }

    @Override
    public void updateStateProject(Project project) {
        projectDaoImpl.updateStateProject(project);
    }

    @Override
    public List<Project> getProjects() {
        return projectDaoImpl.getProjects();
    }

    @Override
    public List<User> getUsers() {
        return projectDaoImpl.getUsers();
    }

    @Override
    public void truncate() {
        projectDaoImpl.truncate();
    }
}
