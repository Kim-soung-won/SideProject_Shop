package com.i.minishopping.Domains.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brand_id;

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brand_name;

    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Builder
    public Brands(String brand_name){
        this.brand_name = brand_name;
        this.created_at = LocalDateTime.now();
    }
}