package io.khasang.stockmanager.dao.desk;

import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.dao.impl.ProjectServiceImpl;
import io.khasang.stockmanager.entity.Project;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
public class ProjectTest {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    private Project project;

    @Before
    public void preparingData() {
        project = new Project();
        project.setProjectName("testProject");
        project.setType("testType");
        project.setTotalAmount(BigDecimal.valueOf(1));
        project.setStartDate(Date.valueOf("2016-01-01"));
        project.setFinishDate(Date.valueOf("2016-01-02"));
        project.setVip(true);
        project.setState("complete");
        project.setUserId(1L);
    }

    @Test
    public void addProjectTest() {
        projectServiceImpl.truncate();
        projectServiceImpl.addProject(project);
        Assert.assertNotNull(projectServiceImpl.getProjects().size());
    }
}
