package com.i.minishopping.DTO.Product;

import com.i.minishopping.DTO.Common.CommonResponse;
import com.i.minishopping.Domains.Product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ProductListResponse extends CommonResponse {
    private Long id;
    private String name;
    private int price;

    public ProductListResponse(int status, String msg){
        super(status,msg);
    }
    public ProductListResponse(int status, String msg, Product product){
        super(status,msg);
        this.id = product.getProduct_id();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
