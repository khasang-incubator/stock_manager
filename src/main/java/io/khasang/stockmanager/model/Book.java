package io.khasang.stockmanager.model;

public class Book {
    private Integer id;
    private String title;
    private Author author;
    private Subject subject;

    public Book() {
    }

    public Book(Integer id, String title, Author author, Subject subject) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
