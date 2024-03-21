package com.i.minishopping.DTO.Product.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private Long id;
    private String name;
    private int price;
    private String category;
}
