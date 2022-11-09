package com.easipm.productservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                                    // expose class as entity for a table in database 
@Table(name="products")
public class Product {
    @Id                                     // id is unique
    @GeneratedValue                        // no need to account for in the body of a post request
    private Integer id;

    private String productName;
    private int categoryId;
    private double unitPrice;



    public Product() {}

    public Product(Integer id, String productName, int categoryId, double unitPrice) {
        this.id = id;
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Products [productName=" + productName + ", id=" + id + ", categoryId=" + categoryId + ", unitPrice="
                + unitPrice + "]";
    }

}
