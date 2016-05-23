package io.khasang.stockmanager.model.pShtykov.model;

public class Department {

    private long id;
    private String department;
    private int room;

    public Department(long id, String department, int room) {
        this.id = id;
        this.department = department;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

}
