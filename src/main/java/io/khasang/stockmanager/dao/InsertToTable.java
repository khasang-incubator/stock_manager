package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertToTable {
    @Autowired
    SessionFactory sessionFactory;

    private String resultQuery;

    public InsertToTable() {
    }

    public boolean insertNewCategory(String name) {
        Session session = sessionFactory.openSession();
        boolean result = true;
        try {
            session.beginTransaction();
            Category category = new Category();
            category.setName(name);
            session.save(category);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    public String initTableCategory() {
        String[] nameCategory = {"Отделочные материалы", "Напольные покрытия", "Лаки и краски", "Крепеж"};
        resultQuery = "Добавлены категории: ";
        for (String s : nameCategory) {
            if (!insertNewCategory(s)) {
                break;
            } else {
                resultQuery += s;
            }
        }
        return resultQuery;
    }
}
