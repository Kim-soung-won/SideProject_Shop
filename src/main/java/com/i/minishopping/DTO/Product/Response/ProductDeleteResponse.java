package com.i.minishopping.DTO.Product.Response;

import com.i.minishopping.DTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDeleteResponse extends CommonResponse {
    private Long id;
    private String name;


    public ProductDeleteResponse(int status, String msg) {
        super(status, msg);
    }
    public ProductDeleteResponse(int status, String msg, Long product_id, String name) {
        super(status, msg);
        this.id = product_id;
        this.name = name;
    }
}
