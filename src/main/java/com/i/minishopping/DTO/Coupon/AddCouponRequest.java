package com.i.minishopping.DTO.Coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCouponRequest {
    private String name;
    private int discount;
    private String brandName;
}
