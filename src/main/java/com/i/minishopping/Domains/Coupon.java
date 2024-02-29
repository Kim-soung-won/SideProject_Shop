package com.i.minishopping.Domains;

import com.i.minishopping.Domains.EMBEDDED.Created;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coupon")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(name = "used")
    private boolean used;

    @Column(name = "coupon_name")
    private String name;

    @Column(name = "discount_size")
    private int discount_size;

    @Column(name = "brand_name")
    private String brand_name;

    @Embedded
    private Created created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
}
