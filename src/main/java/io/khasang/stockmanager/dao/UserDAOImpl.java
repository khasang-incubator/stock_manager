package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

//@Import(HibernateConfig.class)
public class UserDAOImpl implements UserDAO {
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
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
    public User getById(int id) throws NoResultException {
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
