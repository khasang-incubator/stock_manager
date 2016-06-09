package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Project;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Project project) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void delete(Project project) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(project);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<Project> getAll() {
        List list = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            list = session.createCriteria(Project.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Project getById(Integer id) {
        Project project = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            project = session.get(Project.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return project;
    }

}
