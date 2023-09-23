package com.example.lapweek_2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
@NamedQueries(
        @NamedQuery(name = "Customers.findbyId", query = "select cus from Customer cus where cus.cus_id = ?1")
)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer")
    private long cus_id;
    @Column(name = "name", length = 150,nullable = false)
    private String name;
    @Column(name = "address", length = 150, nullable = false)
    private String address;
    @Column(name = "phone", length = 10, nullable = false)
    private String phone;
    @Column(name = "email", length = 150, unique = true)
    private String email;
    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private List<Order> lstOrders;

    public Customer() {
    }

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public long getCus_id() {
        return cus_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public List<Order> getLstOrders() {
        return lstOrders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "cus_id=" + cus_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + lstOrders +
                '}';
    }
}
