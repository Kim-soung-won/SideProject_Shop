package com.i.minishopping.DTO.Product;

import com.i.minishopping.Domains.Product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class ProductListResponse{
    private Long id;
    private String name;
    private int price;

    public ProductListResponse(Product product){
        this.id = product.getProduct_id();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
