package com.i.minishopping.DTORequest.Coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCouponRequest {
    private Long id;
    private Long product_id;
}
