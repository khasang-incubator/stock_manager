package io.khasang.stockmanager.model;

import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.dao.ProductsDao;
import io.khasang.stockmanager.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
public class ProductTest {
    @Autowired
    ProductsDao productsDao;

    @Test
    public void persistTest() {
        Product product = new Product();
        product.setName("Test");
        product.setDescription("Description");
        product.setUserId(1);
        productsDao.persist(product);
        Assert.assertNotNull(product.getId());
    }
}
