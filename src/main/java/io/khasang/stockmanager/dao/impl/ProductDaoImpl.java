package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProductDao;
import io.khasang.stockmanager.entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @SuppressWarnings("unchecked")
    public List<Product> listProduct() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public void removeProduct(Integer id) {
        Product product = sessionFactory.getCurrentSession().load(Product.class, id);
        if (null != product) {
            sessionFactory.getCurrentSession().delete(product);
        }
    }

    @Override
    public void persist(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Product getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
