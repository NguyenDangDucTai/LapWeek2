package com.example.lapweek_2.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "product_price")
public class Product_price {
    @Id
    @OneToOne(mappedBy = "product_price")
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "price_date_time", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private Date price_date_time;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note")
    private String note;

    public Product_price() {
    }

    public Product_price(Product product, Date price_date_time, double price, String note) {
        this.product = product;
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    public Product_price(Date price_date_time, double price, String note) {
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    public Date getPrice_date_time() {
        return price_date_time;
    }

    public double getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice_date_time(Date price_date_time) {
        this.price_date_time = price_date_time;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Product_price{" +
                "product=" + product +
                ", price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}

