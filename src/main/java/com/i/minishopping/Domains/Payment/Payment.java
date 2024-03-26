package com.i.minishopping.Domains.Payment;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
@Getter
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

    @Column(name = "total_price")
    private int total_price;

    @Column(name = "size")
    private String size;
    @Builder
    public Payment(Created created, Product product, int count, int total_price, String size){
        this.created = created;
        this.product_id = product;
        this.count = count;
        this.total_price = total_price;
        this.size = size;
    }
}
