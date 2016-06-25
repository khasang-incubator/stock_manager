package io.khasang.stockmanager.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Projects", schema = "public")
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name = "project_name")
    private String projectName;

    @Basic
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Column(name = "finish_date")
    private Date finishDate;

    @Basic
    @Column(name = "state")
    private String state;

    @Basic
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "vip")
    private boolean vip;

    @Basic
    @Column(name = "user_id")
    private Long userId;

    public Project() {
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (vip != project.vip) return false;
        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (projectName != null ? !projectName.equals(project.projectName) : project.projectName != null) return false;
        if (startDate != null ? !startDate.equals(project.startDate) : project.startDate != null) return false;
        if (finishDate != null ? !finishDate.equals(project.finishDate) : project.finishDate != null) return false;
        if (state != null ? !state.equals(project.state) : project.state != null) return false;
        if (totalAmount != null ? !totalAmount.equals(project.totalAmount) : project.totalAmount != null) return false;
        if (type != null ? !type.equals(project.type) : project.type != null) return false;
        return userId != null ? userId.equals(project.userId) : project.userId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (vip ? 1 : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

}
