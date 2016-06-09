package io.khasang.stockmanager.model;

import io.khasang.stockmanager.dao.UserDAO;
import io.khasang.stockmanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import java.security.InvalidParameterException;

@Component
public class UserEditor {

    @Autowired
    private UserDAO userDAO;
//    @Autowired
//    private User user;

    /**
     * Define operation by params (New user || Update user)
     *
     * @param id
     * @param name
     * @param surname
     * @param login
     * @param password
     * @param email
     * @param role
     * @param newUser
     * @throws InvalidParameterException on params error
     */
    public void defineUserOperationsByParams(String id, String name, String surname, String login, String password, String email,
                                             String role, String newUser) throws InvalidParameterException {
        checkImportantParams(login, role);
        if (newUser != null && newUser.equals("on") && password != null) {
            newUser(name, surname, login, password, email, role);
        } else {
            checkId(id);
            updateUser(id, name, surname, login, email, role);
        }
    }

    public void delete(String id) throws NoResultException {
        try {
            User user = userDAO.getById(Integer.parseInt(id));
            userDAO.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoResultException();
        }
    }

    /**
     * Check login and role params
     *
     * @param login
     * @param role
     * @throws InvalidParameterException on check error
     */
    private void checkImportantParams(String login, String role) throws InvalidParameterException {
        if (login == null || role == null || login.equals("") || role.equals("")) {
            throw new InvalidParameterException();
        }
    }

    /**
     * Check id param
     *
     * @param id
     * @throws InvalidParameterException on check error
     */
    private void checkId(String id) throws InvalidParameterException {
        if (id == null || id.equals("")) {
            throw new InvalidParameterException();
        } else {
            parseId(id);
        }
    }

    /**
     * Update user with userDAO
     *
     * @param id
     * @param name
     * @param surname
     * @param login
     * @param email
     * @param role
     * @throws InvalidParameterException
     */
    private void updateUser(String id, String name, String surname, String login, String email,
                            String role) throws InvalidParameterException {
        User newUser = new User();
        User oldUser = userDAO.getById(parseId(id));
        if (oldUser == null)
            throw new InvalidParameterException();
        newUser.setPassword(oldUser.getPassword());
        newUser.setId(parseId(id));
        newUser.setFirstName(name);
        newUser.setLastName(surname);
        newUser.setLogin(login);
        newUser.setEmail(email);
        newUser.setRole(role);
        userDAO.update(newUser);
    }

    /**
     * Create new user with userDAO
     *
     * @param name
     * @param surname
     * @param login
     * @param password
     * @param email
     * @param role
     */
    private void newUser(String name, String surname, String login, String password, String email,
                         String role) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(surname);
        user.setLogin(login);
        user.setEmail(email);
        user.setRole(role);
        user.setPassword(password);
        userDAO.add(user);
    }

    /**
     * Parse id to int
     *
     * @param id
     * @return int id
     * @throws InvalidParameterException on parse error
     */
    private long parseId(String id) throws InvalidParameterException {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException();
        }
    }

}


