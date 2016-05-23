package io.khasang.stockmanager.model.pShtykov.model;

public class EmployeeDepartment {

    private Employee employee;
    private Department department;

    public EmployeeDepartment(Employee employee, Department department) {
        this.employee = employee;
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
