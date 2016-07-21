package io.khasang.stockmanager.service.impl;

import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Qualifier("userDAOImpl")
    @Autowired
    private UserDAO dao;

    @Override
    public Long getUserIdByLogin(String name) {
        return dao.getUserIdByLogin(name);
    }
}
