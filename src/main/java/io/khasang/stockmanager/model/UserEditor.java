package io.khasang.stockmanager.model;

import java.security.InvalidParameterException;

public class UserEditor {

    public void defineUserOperationsByParams(String id, String name, String surname, String login, String password, String email,
                                             String role, String newUser) {
        if (login == null || role == null) {
            throw new InvalidParameterException();
        }
    }

}


