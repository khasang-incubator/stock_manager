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
    private Long id;

    @Basic
    @Column(name = "project_id")
    private Long projectId;

    @Basic
    @Column(name = "product_id")
    private Long productId;
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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

    public void setAmount(BigDecimal amount) {
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

        if (quantity != that.quantity) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return purchaseDate != null ? purchaseDate.equals(that.purchaseDate) : that.purchaseDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
    }
}
