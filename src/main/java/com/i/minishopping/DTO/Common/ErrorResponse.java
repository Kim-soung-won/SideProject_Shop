package com.i.minishopping.DTO.Common;

import lombok.Setter;

@Setter
public class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(String message) {
        this.status = 400;
        this.message = message;
    }
}
