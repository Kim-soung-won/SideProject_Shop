package com.i.minishopping.Domains;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Embedded
    private Created created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product_id;

    @Column(name = "count")
    private int count;

    @Column(name = "basic_price")
    private int basic_price;

    @Column(name = "discount")
    private int discount;

    @Column(name = "total_price")
    private int total_price;

    @Column(name = "size")
    private String size;
    @Builder
    public Payment(Created created, Product product, int basic_price, int count, int discount, int total_price, String size){
        this.created = created;
        this.product_id = product;
        this.count = count;
        this.basic_price = basic_price;
        this.discount = discount;
        this.total_price = total_price;
        this.size = size;
    }
}
