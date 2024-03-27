package com.i.minishopping.DTOResponse.Payment;

import com.i.minishopping.DTOResponse.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentResponse extends CommonResponse {
    private String name;
    private String size;
    private int price;
    private int count;

    public PaymentResponse(int status, String msg, String name, String size, int price, int count) {
        super(status, msg);
        this.name = name;
        this.size = size;
        this.price = price;
        this.count = count;
    }

}
