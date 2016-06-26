package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.MapPointsDAO;
import io.khasang.stockmanager.model.MapPoints;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapPointsDAOImpl implements MapPointsDAO {

    @Autowired
    SessionFactory sessionFactory;

    public MapPointsDAOImpl() {
    }

    @Override
    public void savePoints(MapPoints mapPoints) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(mapPoints);
        session.getTransaction().commit();
    }

    @Override
    public MapPoints getPointsById(Long mapPointsId) {
        MapPoints mapPoints = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            mapPoints = session.get(MapPoints.class, mapPointsId);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return mapPoints;
    }

    @Override
    public void deletePointsById(Long mapPointsId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MapPoints mapPoints = session.load(MapPoints.class, mapPointsId);
        if (mapPoints != null) {
            session.delete(mapPoints);
        }
        session.getTransaction().commit();
    }
}
