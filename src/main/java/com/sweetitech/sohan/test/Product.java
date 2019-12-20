package com.sweetitech.sohan.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    private long id;
    private String name;
    private long price;
    private String percentage;
    private String productType;

    public Product() {

    }

    public Product(String name, long price, String percentage, String productType) {
        this.name = name;
        this.price = price;
        this.percentage = percentage;
        this.productType = productType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "price", nullable = true)
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }

    @Column(name = "percentage", nullable = true)
    public String getPercentage() {
        return percentage;
    }
    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "productType", nullable = true)
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", percentage='" + percentage + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }
}