package com.i.minishopping.Domains.Product;

import com.i.minishopping.Domains.EMBEDDED.Product_log_key;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_log")
@NoArgsConstructor
@Data
public class Product_Log {
    @EmbeddedId
    private Product_log_key product_log_key;
    @Column(name = "size", nullable = false)
    private String size;
    @Column(name = "count", nullable = false)
    private int count;

    @Builder
    public Product_Log(Product_log_key product_log_key, String size, int count) {
        this.product_log_key = product_log_key;
        this.size = size;
        this.count = count;
    }
}
