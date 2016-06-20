package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.LocationDAO;
import io.khasang.stockmanager.entity.Location;
import io.khasang.stockmanager.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationDAOImpl implements LocationDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Location> getAll() {
        List<Location> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            //noinspection unchecked
            list.addAll(session.createCriteria(Location.class).list());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Location> getLocationsByUserId(Long id) {
        try (Session session = sessionFactory.openSession()){
            System.out.println(id);
            return session.createCriteria(Location.class).add(Restrictions.eq("userId", id)).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Id not found.");
    }

    @Override
    public void delete(Location location) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(location);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Location location) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(location);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
