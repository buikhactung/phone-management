package com.codegym.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String price;
    private String description;
    private java.sql.Date dateOfPurchase;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Phone() {
    }

    public Phone(String name, String price, String description, Date dateOfPurchase) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return String.format("Phone[id=%d, name='%s', dateOfPurchase='%s', price='%s', description='%s'", id, name, dateOfPurchase, price, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(java.sql.Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
