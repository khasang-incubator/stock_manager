package io.khasang.stockmanager.model;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.dao.ProductDAO;
import io.khasang.stockmanager.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class})
@DatabaseSetup("/productTestData.xml")
@Transactional
public class ProductTest {
    @Autowired
    ProductDAO productDAO;

    @Test
    @ExpectedDatabase(value = "/productTest-save.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void saveTest() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Test");
        product.setDescription("Description_saved");
        product.setUserId(1L);
        productDAO.save(product);
        Assert.assertNotNull(product.getId());
        productDAO.getAll(44L);
    }

    @Test
    @ExpectedDatabase(value = "/productTest-delete.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void deleteTest() {
        productDAO.delete(productDAO.getAll(44L).get(0));
        Assert.assertEquals(0, productDAO.getAll(44L).size());
    }

    @Test
    public void getByIdTest() {
        Product product = productDAO.getById(productDAO.getAll(44L).get(0).getId());
        Assert.assertEquals("Test", product.getName());
    }

    @Test
    public void getAll() {
        Assert.assertEquals(1, productDAO.getAll(44L).size());
    }
}
