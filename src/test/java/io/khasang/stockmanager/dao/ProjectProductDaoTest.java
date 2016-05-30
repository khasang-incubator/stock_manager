package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.config.AppContext;
import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, AppContext.class})
public class ProjectProductDaoTest {
    @Autowired
    ProjectProductDao projectProductDao;

    private ProjectProduct projectProduct;
    private Date currentDate;

    @Before
    public void setUp() {
        currentDate = new Date();
        projectProduct = new ProjectProduct();
        projectProduct.setProjectId(2l);
        projectProduct.setAmount(3);
        projectProduct.setPrice(new BigDecimal(20));
        projectProduct.setSumm(new BigDecimal(60));
        projectProduct.setDate(currentDate);
    }


    @Test
    public void testInsertToTable() {
        projectProductDao.insertToTable(projectProduct);
        assertEquals("Result wrong", "sucessfully insert to table", projectProductDao.getResult());
    }

    @Test
    public void testErrorWhenInsertToTable() {
        projectProduct.setAmount(null);
        projectProductDao.insertToTable(projectProduct);
        assertEquals("Result wrong", "unable to insert to table", projectProductDao.getResult());
    }
}
