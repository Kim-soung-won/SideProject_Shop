package com.i.minishopping.Domains;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product_id;

    @Column(name = "count")
    private int count;

    @Embedded
    @JoinColumn(name = "created_who", referencedColumnName = "user_id")
    private Created created;

    @Builder
    public Cart(Product product_id, int count, Created created){
        this.product_id = product_id;
        this.count = count;
        this.created = created;
    }
}
