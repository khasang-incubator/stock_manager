package io.khasang.stockmanager.model;

import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.dao.ProductDao;
import io.khasang.stockmanager.entity.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
@Transactional
public class ProductTest {
    @Autowired
    ProductDao productDao;

    @Before
    public void before() {
        productDao.deleteAll();
        Product product = new Product();
        product.setName("Test");
        product.setDescription("Description");
        product.setUserId(1);
        productDao.save(product);
    }

    @Test
    public void saveTest() {
        Product product = new Product();
        product.setName("Test");
        product.setDescription("Description");
        product.setUserId(1);
        productDao.save(product);
        Assert.assertNotNull(product.getId());
    }

    @Test
    public void deleteTest() {
        productDao.delete(productDao.getAll().get(0));
        Assert.assertEquals(0, productDao.getAll().size());
    }

    @Test
    public void getByIdTest() {
        Product product = productDao.getById(productDao.getAll().get(0).getId());
        Assert.assertEquals("Test", product.getName());
    }
}
