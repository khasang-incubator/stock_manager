package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProductDAO;
import io.khasang.stockmanager.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public void deleteAll() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Product").executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public Product getById(Long id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }
}
