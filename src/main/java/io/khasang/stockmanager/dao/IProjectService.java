package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.User;
import java.util.List;

/**
 *
 * @author ShtykovPavel
 */
public interface IProjectService {

    public void addProject(Project project);

    public void deleteProject(Long projectId);

    public void updateStateProject(Project project);

    public List<Project> getProjects();

    public List<User> getUsers();
}
