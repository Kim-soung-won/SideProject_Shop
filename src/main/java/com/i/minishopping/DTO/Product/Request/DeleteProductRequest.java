package com.i.minishopping.DTO.Product.Request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeleteProductRequest {
    private Long product_id;
}
