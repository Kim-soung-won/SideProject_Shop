package com.i.minishopping.Services.Payment;

import com.i.minishopping.DTORequest.Coupon.UpdateCouponRequest;
import com.i.minishopping.Domains.Product.Brand;
import com.i.minishopping.Domains.Payment.Coupon;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Payment.CouponRepository;
import com.i.minishopping.Services.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final ProductService productService;

    @Transactional
    public Coupon saveCoupon(String name, int size, Brand brands, Created created){
        return couponRepository.save(Coupon.builder()
                        .name(name)
                        .brand_id(brands)
                        .created(created)
                        .discount_size(size)
                .build());
    }

    @Transactional(readOnly = true)
    public Coupon findById(Long id){
        return couponRepository.findById(id).orElse(null);
    }

    @Transactional
    public Coupon useCoupon(Coupon coupon, Product product){
        int discount_price = (int)(product.getPrice() * (coupon.getDiscount_size() / 100.0));
        coupon.usedCoupon(LocalDateTime.now(), product, discount_price);
        return coupon;
    }


}
