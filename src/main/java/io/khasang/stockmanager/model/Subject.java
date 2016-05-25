package io.khasang.stockmanager.model;

public class Subject {
    private Integer id;
    private String subject;
    private String location;

    public Subject() {
    }

    public Subject(Integer id, String subject, String location) {
        this.id = id;
        this.subject = subject;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
