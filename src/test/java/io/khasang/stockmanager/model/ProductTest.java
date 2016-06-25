package io.khasang.stockmanager.model;

import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.dao.ProductDAO;
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
    ProductDAO productDAO;

    @Before
    public void before() {
        productDAO.deleteAll();
        Product product = new Product();
        product.setName("Test");
        product.setDescription("Description");
        product.setUserId(1L);
        productDAO.save(product);
    }

    @Test
    public void saveTest() {
        Product product = new Product();
        product.setName("Test");
        product.setDescription("Description");
        product.setUserId(1L);
        productDAO.save(product);
        Assert.assertNotNull(product.getId());
    }

    @Test
    public void deleteTest() {
        productDAO.delete(productDAO.getAll().get(0));
        Assert.assertEquals(0, productDAO.getAll().size());
    }

    @Test
    public void getByIdTest() {
        Product product = productDAO.getById(productDAO.getAll().get(0).getId());
        Assert.assertEquals("Test", product.getName());
    }
}
