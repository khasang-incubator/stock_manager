package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.User;
import java.util.List;

public interface IProjectDAO {

    void addProject(Project project);

    void deleteProject(Long projectId);

    void updateStateProject(Project project);

    List<Project> getProjects();

    List<User> getUsers();

    void truncate() ;
}
