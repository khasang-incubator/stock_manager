package io.khasang.stockmanager.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ShtykovPavel
 */
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @Column(name = "id")
    private Long id;
    
    @Basic
    @Column(name = "first_name")
    private String first_name;
    
    @Basic
    @Column(name = "last_name")
    private String last_name;
    
    @Basic
    @Column(name = "login")
    private String login;
    
    @Basic
    @Column(name = "password")
    private String password;
    
    @Basic
    @Column(name = "e_mail")
    private String e_mail;
    
    @Basic
    @Column(name = "role")
    private String role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
