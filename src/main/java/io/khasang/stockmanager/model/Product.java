package io.khasang.stockmanager.model;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private int id;
    private int providerId;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

