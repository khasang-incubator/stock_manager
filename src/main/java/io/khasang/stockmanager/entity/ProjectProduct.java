package io.khasang.stockmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ProjectProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int projectId;
    private int quantity;
    private BigDecimal price;
    private BigDecimal sum;
    private LocalDate saleDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectProduct that = (ProjectProduct) o;

        if (id != that.id) return false;
        if (projectId != that.projectId) return false;
        if (quantity != that.quantity) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;
        return saleDate != null ? saleDate.equals(that.saleDate) : that.saleDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + projectId;
        result = 31 * result + quantity;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (saleDate != null ? saleDate.hashCode() : 0);
        return result;
    }
}
