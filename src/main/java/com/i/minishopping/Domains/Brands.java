package com.i.minishopping.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "count_sale")
    private Long count_sale;

    @Builder
    public Brands(String brand_name){
        this.brand_name = brand_name;
        this.count_sale = 0L;
    }
}
