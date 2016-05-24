package com.cliffdurden.spring.javaconfig.helloworld.model;

public class EmployeeInfo extends Employee {

    private String deptName;
    private String deptDescription;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }
}
