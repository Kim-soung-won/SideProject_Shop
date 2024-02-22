package com.i.minishopping.Domains;


import com.i.minishopping.Domains.EMBEDDED.Created;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "pd_name", nullable = false)
    private String name;

    @Column(name = "pd_price")
    private int price;

    @Column(name = "pd_brand_name")
    private String brandName;

    @Column(name = "pd_category")
    private String category;

    @Column(name = "pd_before_count")
    private int beforeCount;

    @Column(name = "pd_sell_count")
    private int sellCount;

    @Embedded
    private Created created;

    @Builder
    public Product(String name, int price, String brandName, String category, int beforeCount, Created created){
        this.name = name;
        this.price = price;
        this.brandName = brandName;
        this.category = category;
        this.beforeCount = beforeCount;
        this.sellCount = 0;
        this.created = created;
    }
}
