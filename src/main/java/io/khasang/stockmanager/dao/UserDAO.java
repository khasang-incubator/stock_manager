package io.khasang.stockmanager.dao;

import io.khasang.stockmanager.entity.Users;

import java.util.List;

public interface UserDAO {
    List<Users> getAll();

    void change(Users user);
}
