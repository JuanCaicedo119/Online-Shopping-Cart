package com.easipm.customerservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                                    // expose class as entity for a table in database 
@Table(name="customers")
public class Customer {
    @Id                                     // id is unique
    @GeneratedValue                        // no need to account for in the body of a post request
    private Integer id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Customer() {}

    public Customer(Integer id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", phoneNumber="
                + phoneNumber + "]";
    }

}
