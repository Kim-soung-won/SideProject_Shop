package com.i.minishopping.DTORequest.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeleteCartRequest {
    private Long product_id;
    private String size;
}
