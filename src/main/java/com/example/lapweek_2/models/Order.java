package com.example.lapweek_2.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private long order_id;
    @Column(name = "orderDate", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private Date orderDate;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customers;
    @OneToOne(mappedBy = "Orders")
    private Order_detail orderDetail;
    public Order() {
    }

    public Order(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getOrder_id() {
        return order_id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Customer getCustomers() {
        return customers;
    }

    public Order_detail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                ", customers=" + customers +
                '}';
    }
}
