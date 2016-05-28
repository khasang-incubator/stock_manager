package io.khasang.stockmanager.model;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "providers")
public class Provider {
    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    private char type;
}
