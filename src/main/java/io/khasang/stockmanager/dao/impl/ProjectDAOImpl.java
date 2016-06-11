package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.IProjectDAO;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
*Proj DAO Impl
* */
@Component
public class ProjectDAOImpl implements IProjectDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProject(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(project);
        session.getTransaction().commit();
    }

    @Override
    public void deleteProject(Long projectId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Project project = session.load(Project.class, projectId);
        if (project != null) {
            session.delete(project);
        }
        session.getTransaction().commit();
//        Project project = sessionFactory.getCurrentSession().load(Project.class, projectId); // для работы с аннотацией @Transactional
//        if(project != null) sessionFactory.getCurrentSession().delete(project);  // для работы с аннотацией @Transactional
    }

    @Override
    public void updateStateProject(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        Project projectUpdate = session.load(Project.class, project.getId()); // разобраться, почему-то не работает поиск по Id Project
        if (project != null) {
            session.update(project);
        }
        session.getTransaction().commit();
    }

    @Override
    public List<Project> getProjects() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Project p ORDER BY p.id ASC").list();
    }

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from User u ORDER BY u.id ASC").list();
    }

    @Override
    public void truncate() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete from Project").executeUpdate();
        session.getTransaction().commit();
    }
}
