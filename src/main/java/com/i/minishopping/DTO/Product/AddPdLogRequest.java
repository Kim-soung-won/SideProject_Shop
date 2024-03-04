package com.i.minishopping.DTO.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddPdLogRequest {
    private Long product_id;
    private String size;
    private int count;
}
