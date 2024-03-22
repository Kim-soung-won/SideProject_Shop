package com.i.minishopping.DTO.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
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

    @Override
    public String toString() {
        return  "{product_id=" + product_id +
                ", count=" + count +
                ", total_price=" + total_price +
                ", size='" + size + '\'' +
                '}';
    }
}
