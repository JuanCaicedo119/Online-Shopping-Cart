package com.easipm.restfulwebservices.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                                    // expose class as entity for a table in database 
@Table(name="orderdetails")
public class OrderDetails {
    @Id                                     // id is unique
    @GeneratedValue                        // no need to account for in the body of a post request
    private Integer id;

    /**
     * TODO:
     *      Find something similar to this
     *      @Size(min=2, message = "Name should have atleast 2 characters")
     */
    
    private int order_id;
    private int product_id;
    private int quantity;

    // @OneToMany(mappedBy = "user")
	// private List<Post> posts;

    public OrderDetails() {}

    public OrderDetails(Integer id, int order_id, int product_id, int quantity) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails [order_id=" + order_id + ", id=" + id + ", product_id=" + product_id + ", quantity="
                + quantity + "]";
    }

}
