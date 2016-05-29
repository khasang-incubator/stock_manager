package io.khasang.stockmanager.dao;


import io.khasang.stockmanager.config.application.WebConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
public class ProductDaoTest {

    @Autowired
    ProjectDao projectDao;

    @Test
    public void testInsertToTable(){
        projectDao.isertToTable(new Project());
        assertEquals("Result wrong", "sucessfully insert to table", projectDao.getResult());
    }

}
