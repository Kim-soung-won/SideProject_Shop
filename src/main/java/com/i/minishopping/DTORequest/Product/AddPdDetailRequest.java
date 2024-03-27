package com.i.minishopping.DTORequest.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddPdDetailRequest {
    private Long product_id;
    private String size;
    private int beforeCount;
}
