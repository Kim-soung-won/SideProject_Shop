package com.i.minishopping.DTOResponse.Product;

import com.i.minishopping.DTOResponse.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BrandAddResponse extends CommonResponse {
    private String name;
    public BrandAddResponse(int status, String msg,String name){
        super(status, msg);
        this.name = name;
    }
}
