package io.khasang.stockmanager.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ShtykovPavel
 */
@Entity
@Table(name = "project_product", schema = "public")
public class ProjectProduct {

    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "project_id")
    private Long project_id;

    @Basic
    @Column(name = "quantity")
    private int quantity;

    @Basic
    @Column(name = "price")
    private BigDecimal price;

    @Basic
    @Column(name = "amount")
    private int amount;

    @Basic
    @Column(name = "purchase_date")
    private Timestamp purchase_date;

    public ProjectProduct() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Timestamp purchase_date) {
        this.purchase_date = purchase_date;
    }

}
