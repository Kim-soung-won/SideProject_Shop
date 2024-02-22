package com.i.minishopping.DTO.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddCartRequest {
    private Long product_id;
    private Long user_id;
    private int count;
}
