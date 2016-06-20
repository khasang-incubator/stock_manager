package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public String insertToTable(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            //Receive status with specify id - required for check field state = at status end or not.
            List list = session.createCriteria(User.class, "id")
                    .list();
            session.save(user);
            session.getTransaction().commit();
            return "successfully insert to table";
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return "unable to insert to table";
        } finally {
            session.close();
        }
    }

    @Override
    public Long getUserIdByLogin(String name) {
        try (Session session = sessionFactory.openSession()){
            User user = (User) session.createCriteria(User.class).add(Restrictions.eq("login", name)).uniqueResult();
            return user.getId();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Id not found.");
    }

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
    public void update(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(Long id) throws NoResultException {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Criterion c = Restrictions.eq("id", id);
            user = (User) session.createCriteria(User.class).add(c).uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new NoResultException();
        }
        return user;
    }

    @Override
    public void delete(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}
