package io.khasang.stockmanager.model;

import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.dao.ProductDao;
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
    ProductDao productsDao;

    @Test
    public void persistTest() {
        Product product = new Product();
        product.setName("Test");
        product.setDescription("Description");
        product.setUserId(1);
        productsDao.persist(product);
        Assert.assertNotNull(product.getId());
    }
    @Test
    public void deleteTest() {
        Product product = new Product();
        product.setId(2);
        product.setName("Test");
        product.setDescription("Description");
        product.setUserId(1);
        productsDao.delete(product);
        Assert.assertEquals (null,product.getName());
    }

    @Test
    public void getByIdTest() {
        int id = 1;
        Product product = productsDao.getById(id);
        Assert.assertEquals("Test", product.getName());
    }
}
