package com.example.lapweek_2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class Product_image {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long image_id;
    @Column(name = "alternative", length = 150, nullable = false)
    private String alternative;
    @Column(name = "path", length = 150, nullable = false)
    private String path;

    public Product_image() {
    }

    public Product_image(String alternative, String path) {
        this.alternative = alternative;
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public long getImage_id() {
        return image_id;
    }

    public String getAlternative() {
        return alternative;
    }

    public String getPath() {
        return path;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Product_image{" +
                "product=" + product +
                ", image_id=" + image_id +
                ", alternative='" + alternative + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
