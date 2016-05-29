package io.khasang.stockmanager.entity;

import io.khasang.stockmanager.config.HibernateConfig;
import io.khasang.stockmanager.config.application.WebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class ProjectTest {
    @Autowired
    private Project project;

    @Before
    public void beforeTest() {
        project.setTitle("test_project");
        project.setUserId(1);
        project.setStartDate(LocalDate.now());
        project.setFinishDate(LocalDate.now().plusDays(2));
        project.setStatus(ProjectStatus.ACTIVE);
        project.setBudget(10000);
        project.setType("ddd");
    }

    @Test
    public void testProjectNotNull() {
        Assert.assertNotNull(project);
    }

    @Test
    public void testGetTitle() {
        Assert.assertEquals("test_project", project.getTitle());
    }
}
