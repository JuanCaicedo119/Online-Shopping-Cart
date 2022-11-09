package com.easipm.orderservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                                    // expose class as entity for a table in database 
@Table(name="orders")
public class Order {
    @Id                                     // id is unique
    @GeneratedValue                        // no need to account for in the body of a post request
    private Integer id;

    private int orderId;
    private int customerId;
    private String orderDate;

    public Order() {}

    public Order(Integer id, int orderId, int customerId, String orderDate) {
        this.id = id;
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", id=" + id + ", customerId=" + customerId + ", orderDate="
                + orderDate + "]";
    }

}
