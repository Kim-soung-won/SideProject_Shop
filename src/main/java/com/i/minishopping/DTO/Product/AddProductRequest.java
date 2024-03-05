package com.i.minishopping.DTO.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddProductRequest {
    private String name;
    private int price;
    private String brandName;
    private String category;
}
