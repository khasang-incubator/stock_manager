package io.khasang.stockmanager.dao.desk;

import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.dao.impl.ProjectProductServiceImpl;
import io.khasang.stockmanager.entity.ProjectProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author ShtykovPavel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
public class ProjectProductTest {

    @Autowired
    private ProjectProductServiceImpl projectProductServiceImplImpl;

    private ProjectProduct projectProduct;

    @Before
    public void preparingData() {
        projectProduct = new ProjectProduct();
        projectProduct.setProjectId(1L);
        projectProduct.setAmount(new BigDecimal(1));
        projectProduct.setPrice(new BigDecimal(0.9));
        projectProduct.setQuantity(1);
        projectProduct.setPurchaseDate(Date.valueOf("2016-01-02"));
    }

    @Test
    public void addProjectTest() {
        projectProductServiceImplImpl.truncate();
        projectProductServiceImplImpl.addProjectProduct(projectProduct);
        Assert.assertNotNull(projectProductServiceImplImpl.getProjectProducts().size());
    }
}
