package com.example.productManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private double price;
    @Column
    private String brand;
    @Column
    private String color;
    @Column
    private String description;

    @Override
    public String toString() {
        return "Product [id=" + productId + ", name=" + name + ", category=" + category + ", price=" + price + ", brand=" + brand + ", color=" + color + ", description=" + description + "]";
    }
}
