package com.i.minishopping.DTO.Payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPaymentRequest {
    private Long product_id;
    private int count;
    private int total_price;
    private String size;
}
