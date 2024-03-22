package com.i.minishopping.Domains.Payment;

import com.i.minishopping.Domains.Product.Brand;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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


    @Column(name = "coupon_name")
    private String name;

    @Column(name = "discount_size")
    private int discount_size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand_id;

    @Column(name = "used")
    private boolean used;
    @Embedded
    private Created created;

    @Column(name = "used_at")
    private LocalDateTime used_at;

    @Column(name = "discount_price")
    private int discount_price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product_id;

    @Builder
    public Coupon(String name, int discount_size, Brand brand_id, Created created){
        this.name = name;
        this.discount_size = discount_size;
        this.brand_id = brand_id;
        this.created = created;
    }
    public void usedCoupon(LocalDateTime used_at, Product product_id, int discount_price){
        this.used = true;
        this.used_at = used_at;
        this.product_id = product_id;
        this.discount_price = discount_price;
    }
}
