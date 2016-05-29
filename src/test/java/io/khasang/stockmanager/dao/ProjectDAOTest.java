package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.config.HibernateConfig;
import io.khasang.stockmanager.config.application.WebConfig;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectStatus;
import org.hibernate.SessionFactory;
import org.junit.Assert;
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
public class ProjectDAOTest {
    @Autowired
    private Project project;

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void addTest() {
        project.setTitle("test_project");
        project.setUserId(1);
        project.setStartDate(LocalDate.now());
        project.setFinishDate(LocalDate.now().plusDays(2));
        project.setStatus(ProjectStatus.ACTIVE);
        project.setBudget(10000);
        project.setType("ddd");

        Project projectTest = (Project) sessionFactory.getCurrentSession().load(Project.class, 1);

        Assert.assertEquals(project, projectTest);
    }

//    @Repository("userDao")
//    public class UserDao implements IUserDao {
//
//        @Autowired
//        private SessionFactory sessionFactory;
//
//        public void SaveUser(User user) {
//            sessionFactory.getCurrentSession().save(user);
//        }
//        @SuppressWarnings("unchecked")
//        public List<User> ListUsers() {
//            List<User> users = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
//            return users;
//        }
//        public User GetUserById(Integer id) {
//            User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
//            return user;
//        }
//    }

    @Test
    public void deleteTest() {

    }

    @Test
    public void getAllTest() {

    }

    @Test
    public void getByIdTest() {

    }
}
