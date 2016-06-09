package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    SessionFactory sessionFactory;

    public String insertToTable(User user) {

    User getById(int id);

    void delete(User user);
}
