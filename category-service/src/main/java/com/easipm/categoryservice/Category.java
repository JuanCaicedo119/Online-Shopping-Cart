package com.easipm.categoryservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                                    // expose class as entity for a table in database 
@Table(name="category")
public class Category {
    @Id                                     // id is unique
    @GeneratedValue                        // no need to account for in the body of a post request
    private Integer id;
    
    private String categoryname;
    private String description;

    public Category() {}

    public Category(Integer id, String categoryname, String description) {
        this.id = id;
        this.categoryname = categoryname;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryname;
    }

    public void setCategoryName(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category [categoryname=" + categoryname + ", id=" + id + ", description=" + description + "]";
    }
}