package io.khasang.stockmanager.dao;


import io.khasang.stockmanager.config.AppContext;
import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.entity.Project;
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
    ProjectDao projectDao;

    @Test
    public void testInsertToTable(){
        projectDao.insertToTable(new Project());
        assertEquals("Result wrong", "sucessfully insert to table", projectDao.getResult());
    }

}
