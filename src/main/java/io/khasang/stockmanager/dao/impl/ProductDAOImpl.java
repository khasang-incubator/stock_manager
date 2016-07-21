package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProductDAO;
import io.khasang.stockmanager.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


/**
* Prod DAO 
* */
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
        if (product == null) return;
        sessionFactory.getCurrentSession().delete(product);
        sessionFactory.getCurrentSession().createQuery("DELETE FROM ProductSalePlace " +
                "where product_id = :productId")
                .setParameter("productId", product.getId()).executeUpdate();
    }

    @Override
    public void deleteAll() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Product").executeUpdate();
        sessionFactory.getCurrentSession().createQuery("DELETE FROM ProductSalePlace").executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAllByUser(Long userId) {
        if (userId == null)
            return Collections.emptyList();
        return sessionFactory.getCurrentSession().createQuery("from Product " +
                "where user_id = :userId")
                .setParameter("userId", userId).list();
    }

    @Override
    public Product getById(Long id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }
}
