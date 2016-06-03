package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();

    void change(User user);

    void add(User user);
}
