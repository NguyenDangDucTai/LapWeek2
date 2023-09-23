package com.example.lapweek_2.models;

import com.example.lapweek_2.enums.ProductStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product__id", nullable = false)
    private long product_id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Column(name = "description", nullable = false, length = 150)
    private String description;
    @Column(name = "unit", nullable = false, length = 150)
    private String unit;
    @Column(name = "manufacturer_name", nullable = false, length = 150)
    private String manufacturer_name;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;
    @OneToMany(mappedBy = "product")
    @JoinColumn(name = "order_id")
    private List<Order_detail> lstOrderDetail;
    @OneToMany(mappedBy = "product")
    @JoinColumn(name = "product_image_id")
    private List<Product_image> lstProductImage;

    @OneToOne
    private Product_price productPrice;

    public Product() {
    }

    public Product(long product_id, String name, String description, String unit, String manufacturer_name, ProductStatus status, List<Product_image> lstProductImage, Product_price productPrice) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
        this.lstProductImage = lstProductImage;
        this.productPrice = productPrice;
    }

    public long getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public List<Order_detail> getLstOrderDetail() {
        return lstOrderDetail;
    }

    public List<Product_image> getLstProductImage() {
        return lstProductImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Product_price getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Product_price productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", status=" + status +
                ", lstOrderDetail=" + lstOrderDetail +
                ", lstProductImage=" + lstProductImage +
                '}';
    }
}
