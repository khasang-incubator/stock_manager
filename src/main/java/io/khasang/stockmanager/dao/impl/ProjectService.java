package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.IProjectService;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectDao projectDao;

//    @Transactional
    @Override
    public void addProject(Project project) {
        projectDao.addProject(project);
    }

//    @Transactional
    @Override
    public void deleteProject(Long projectId) {
        projectDao.deleteProject(projectId);
    }

    @Override
    public void updateStateProject(Project project) {
        projectDao.updateStateProject(project);
    }

    @Override
    public List<Project> getProjects() {
        return projectDao.getProjects();
    }

    @Override
    public List<User> getUsers() {
        return projectDao.getUsers();
    }

    @Override
    public void truncate() {
        projectDao.truncate();
    }
}
