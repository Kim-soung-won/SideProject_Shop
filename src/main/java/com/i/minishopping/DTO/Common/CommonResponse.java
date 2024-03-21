package com.i.minishopping.DTO.Common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommonResponse {
    private int status;
    private String msg;

    public CommonResponse(int status,String msg) {
        this.status = status;
        this.msg = msg;
    }
}
