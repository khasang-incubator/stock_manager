package io.khasang.stockmanager.entity;

import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ShtykovPavel
 */
@Entity
@Table(name = "Projects", schema = "public")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic
    @Column(name = "project_name")
    private String project_name;
    
    @Basic
    @Column(name = "start_date")
    private Timestamp start_date;
    
    @Basic
    @Column(name = "finish_date")
    private Timestamp finish_date;
    
    @Basic
    @Column(name = "state")
    private String state;
    
    @Basic
    @Column(name = "total_amount")
    private int total_amount;
    
    @Basic
    @Column(name = "type")
    private String type;
    
    @Basic
    @Column(name = "vip")
    private boolean vip;
    
    @Basic
    @Column(name = "user_id")
    private long user_id;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Timestamp finish_date) {
        this.finish_date = finish_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }  
}
