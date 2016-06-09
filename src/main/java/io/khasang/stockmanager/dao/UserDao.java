package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();

    void update(User user);

    void add(User user);

    User getById(long id);

    void delete(User user);

    String insertToTable(User user);
}
