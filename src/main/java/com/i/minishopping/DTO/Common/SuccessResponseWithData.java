package com.i.minishopping.DTO.Common;

import com.i.minishopping.Domains.Product.Product;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor

public class SuccessResponseWithData {
    private int status;
    private String msg;
    private Object data;

    public SuccessResponseWithData(Object data) {
        this.status = 200;
        this.msg = "success!!";
        this.data = data;
    }

    public SuccessResponseWithData(String msg, Object data) {
        this.status = 200;
        this.msg = msg;
        this.data = data;
    }

}
