package io.khasang.stockmanager.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SelectDao {
    @Autowired
    private SessionFactory sessionFactory;


    public List getInnerSelect() {
        String query = "FROM Product WHERE providerId IN (SELECT id FROM Provider WHERE type = ?)";
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery(query).setParameter(0, 'A').list();
        } finally {
            session.close();
        }
    }
}
