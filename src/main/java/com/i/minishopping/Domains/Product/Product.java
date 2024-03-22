package com.i.minishopping.Domains.Product;


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
    private Long product_id;

    @Column(name = "pd_name", nullable = false)
    private String name;

    @Column(name = "pd_price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand_id;

    @Column(name = "pd_category")
    private String category;

    @Embedded
    @JoinColumn(name = "created_who", referencedColumnName = "user_id")
    private Created created;

    @Column(name = "count_love")
    private int count_love;

    @Builder
    public Product(String name, int price, Brand brand_id, String category, Created created){
        this.name = name;
        this.price = price;
        this.brand_id = brand_id;
        this.category = category;
        this.created = created;
    }
    public void updateProduct(String name, int price, String category, Created created){
        this.name = name;
        this.price = price;
        this.category = category;
        this.created = created;
    }
}
