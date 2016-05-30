package io.khasang.stockmanager.entity;

import javax.persistence.*;

@Entity
public class Project {


    //projects(id, название проекта, id пользователя, дата начала проекта, дата конца проекта, статус, бюджет на проект, тип проекта, VIP).

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String projectName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
