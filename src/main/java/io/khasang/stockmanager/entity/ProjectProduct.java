package io.khasang.stockmanager.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "project_product")
public class ProjectProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column(name = "project_id")
    private int projectId;

    @Basic
    @Column(name = "product_id")
    private int productId;
    
    @Basic
    @Column(name = "quantity")
    private int quantity;

    @Basic
    @Column(name = "price")
    private BigDecimal price;

    @Basic
    @Column(name = "amount")
    private BigDecimal amount;

    @Basic
    @Column(name = "purchase_date")
    private Date purchaseDate;

    public ProjectProduct() {
    }

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectProduct that = (ProjectProduct) o;

        if (id != that.id) return false;
        if (projectId != that.projectId) return false;
        if (productId != that.productId) return false;
        if (quantity != that.quantity) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        return purchaseDate != null ? purchaseDate.equals(that.purchaseDate) : that.purchaseDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + projectId;
        result = 31 * result + productId;
        result = 31 * result + quantity;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
    }

}
