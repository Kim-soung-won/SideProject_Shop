package com.i.minishopping.DTO.Common;

import lombok.Setter;

@Setter
public class SuccessResponse {
    private int status;
    private String message;

    public SuccessResponse(String message, Object data) {
        this.status = 200;
        this.message = message;
    }
}
