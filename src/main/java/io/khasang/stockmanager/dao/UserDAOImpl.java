package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//@Import(HibernateConfig.class)
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            //noinspection unchecked
            list.addAll(session.createCriteria(User.class).list());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void change(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
