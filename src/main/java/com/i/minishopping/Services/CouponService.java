package com.i.minishopping.Services;

import com.i.minishopping.DTO.Coupon.UpdateCouponRequest;
import com.i.minishopping.Domains.Brands;
import com.i.minishopping.Domains.Coupon;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.CouponRepository;
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
    public Coupon saveCoupon(String name, int size, Brands brands, Created created){
        return couponRepository.save(Coupon.builder()
                        .name(name)
                        .brand_id(brands)
                        .created(created)
                        .discount_size(size)
                .build());
    }
    public Coupon findById(Long id){
        return couponRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found: " + id));
    }

    @Transactional
    public Coupon useCoupon(UpdateCouponRequest request){
        Product product = productService.findById(request.getProduct_id());
        Coupon coupon = couponRepository.findById(request.getId()).orElseThrow(()->new IllegalArgumentException("not found: " + request.getId()));
        coupon.usedCoupon(LocalDateTime.now(), product);
        return coupon;
    }

}
