package io.khasang.stockmanager.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StockRegistration {
    @Autowired
    DataExample dataExample;

    private int ID;
    @NotNull
    @Size(min=2, max=30)
    private String firstName;
    @NotNull
    @Size(min=2, max=30)
    private String lastName;
    @NotEmpty
    private String email;
    @NotNull
    @Size(min=5, max=16)
    private String userName;
    @NotNull
    @Size(min=5, max=25)
    private String password;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void save(StockRegistration user) {
        dataExample.addUser(user);
    }

    public StockRegistration find(String userName) {
        return (StockRegistration) dataExample.findUser(userName).get(0);
    }
}
