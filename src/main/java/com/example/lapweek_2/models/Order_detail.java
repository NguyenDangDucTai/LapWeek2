package com.example.lapweek_2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class Order_detail {
    @Id
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order orders;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quatity", nullable = false)
    private double quantity;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note")
    private String note;

    public Order_detail() {
    }

    public Order_detail(Order orders, Product product, double quantity, double price, String note) {
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Order getOrders() {
        return orders;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order_detail{" +
                "orders=" + orders +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
