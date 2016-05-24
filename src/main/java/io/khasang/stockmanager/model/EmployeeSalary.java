package io.khasang.stockmanager.model;

public class EmployeeSalary extends Employee {

    private int salary;
    private String currency;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
