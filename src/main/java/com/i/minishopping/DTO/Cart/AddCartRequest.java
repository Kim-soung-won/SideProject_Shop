package com.i.minishopping.DTO.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddCartRequest {
    private Long product_id;
    private String size;
    private int count;
//    {
//        "product_id" : 23501,
//            "user_id" : 1,
//            "count" : 10
//    }
}
