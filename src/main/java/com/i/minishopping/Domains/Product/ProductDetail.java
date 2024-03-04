package com.i.minishopping.Domains.Product;

import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_detail")
@Data
public class ProductDetail {
    @EmbeddedId
    private Product_Detail_key product_detail_key;

    @Column(name = "pd_before_count")
    private int beforeCount;
    @Column(name = "pd_sell_count")
    private int sellCount;

    @Builder
    public ProductDetail(Product_Detail_key product_detail_key, int beforeCount) {
        this.product_detail_key = product_detail_key;
        this.beforeCount = beforeCount;
    }

    public void sellPd(int count){
        this.beforeCount -= count;
        this.sellCount += count;
    }
}
