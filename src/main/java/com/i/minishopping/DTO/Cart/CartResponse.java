package com.i.minishopping.DTO.Cart;

import com.i.minishopping.DTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartResponse extends CommonResponse {
    String name;

    public CartResponse(int status, String msg, String name) {
        super(status, msg);
        this.name = name;
    }
}
