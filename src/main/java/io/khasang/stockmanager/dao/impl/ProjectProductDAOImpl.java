package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProjectProductDAO;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectProductDAOImpl implements ProjectProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProjectProduct(ProjectProduct projectProduct) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(projectProduct);
        session.getTransaction().commit();
    }

    @Override
    public void deleteProjectProduct(Long projectProductId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ProjectProduct projectProduct = session.load(ProjectProduct.class, projectProductId);
        if(projectProduct != null) {
            session.delete(projectProduct);
        }
        session.getTransaction().commit();

    }

    @Override
    public void updateStateProjectProduct(ProjectProduct projectProduct) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if (projectProduct != null) {
            session.delete(projectProduct);
        }
        session.getTransaction().commit();
    }

    @Override
    public List<ProjectProduct> getProjectProducts() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from ProjectProduct pp ORDER BY pp.id ASC").list();
    }

    @Override
    public List<Project> getProjects() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Project p ORDER BY p.id ASC").list();
    }

    @Override
    public void truncate() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
            session.createQuery("delete from ProjectProduct");
        session.getTransaction().commit();
    }

}
