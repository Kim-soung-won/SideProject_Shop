package com.i.minishopping.DTO.Payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPaymentRequest {
    private Long product_id;
    private int basic_price;
    private int count;
    private int discount;
    private int total_price;
}
