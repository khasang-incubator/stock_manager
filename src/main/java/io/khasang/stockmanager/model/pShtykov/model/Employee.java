package io.khasang.stockmanager.model.pShtykov.model;

public class Employee {

    private long id;
    private String employee;
    private int room;

    public Employee(long id, String employee, int room) {
        this.id = id;
        this.employee = employee;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

}
