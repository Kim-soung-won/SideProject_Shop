package com.i.minishopping.DTOResponse.Product;

import com.i.minishopping.DTOResponse.Common.CommonResponse;
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
