package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.ProductSalePlaceDAO;
import io.khasang.stockmanager.entity.ProductSalePlace;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductSalePlaceDAOImpl implements ProductSalePlaceDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<ProductSalePlace> getAllByProductId(Long productId) {
        return sessionFactory.getCurrentSession().createQuery("from ProductSalePlace " +
                "where product_id = :productId")
                .setParameter("productId", productId).list();
    }

    @Override
    public void save(ProductSalePlace productSalePlace) {
        sessionFactory.getCurrentSession().saveOrUpdate(productSalePlace);
    }

    @Override
    public void delete(ProductSalePlace productSalePlace) {
        sessionFactory.getCurrentSession().delete(productSalePlace);
    }

}
