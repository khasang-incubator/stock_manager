package io.khasang.stockmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String title;
    private int userId;
    private LocalDate startDate;
    private LocalDate finishDate;
    private ProjectStatus status;
    private int budget;
    private String type;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setStartDate(LocalDate starDate) {
        this.startDate = starDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
