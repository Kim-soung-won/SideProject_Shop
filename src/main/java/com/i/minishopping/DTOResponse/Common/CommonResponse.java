package com.i.minishopping.DTOResponse.Common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {
    private int code;
    private String msg;
}
