package com.example.productManager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column
    private int userId;
    @Column
    private int totalAmount;
    @Column
    private String date;
}
