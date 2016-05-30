package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.config.AppContext;
import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.entity.Product;
import io.khasang.stockmanager.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, AppContext.class})
public class ProductDaoTest {
    @Autowired
    ProductDao productDao;

    private Product product;
    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setFirstName("James");
        user.setLastName("Smith");
        user.setLogin("jsmith");
        user.setPassword("qwerty");
        user.setEmail("jsmith@google.com");
        user.setRole("admin");
        product = new Product();
        product.setUser(user);
        product.setProductName("wood");
        product.setDescription("norwegian wood");
    }

    @Test
    public void testInsertToTable() {
        productDao.insertToTable(product);
        assertEquals("Result wrong", "sucessfully insert to table", productDao.getResult());
    }

    @Test
    public void testErrorWhenInsertToTable() {
        product.setProductName(null);
        productDao.insertToTable(product);
        assertEquals("Result wrong", "unable to insert to table", productDao.getResult());
    }
}
