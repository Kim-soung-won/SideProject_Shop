package com.i.minishopping.DTO.Coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCouponRequest {
    private LocalDateTime used_at;
    private Long product_id;
}
