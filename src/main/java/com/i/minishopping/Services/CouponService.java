package com.i.minishopping.Services;

import com.i.minishopping.Domains.Brands;
import com.i.minishopping.Domains.Coupon;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Repositorys.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public Coupon saveCoupon(String name, int size, Brands brands, Created created){
        return couponRepository.save(Coupon.builder()
                        .name(name)
                        .brand_id(brands)
                        .created(created)
                        .discount_size(size)
                .build());
    }

}
