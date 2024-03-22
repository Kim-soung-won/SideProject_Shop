package com.i.minishopping.Services.Payment;

import com.i.minishopping.DTO.Coupon.UpdateCouponRequest;
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
    public Coupon findById(Long id){
        return couponRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found: " + id));
    }

    @Transactional
    public Coupon useCoupon(UpdateCouponRequest request){
        Coupon coupon = couponRepository.findById(request.getId()).orElseThrow(()->new IllegalArgumentException("not found: " + request.getId()));
        if(coupon.isUsed()) throw new IllegalArgumentException("already used: " + request.getId());
        Product product = productService.findById(request.getProduct_id());
        int discount_price = (int)(product.getPrice() * (coupon.getDiscount_size() / 100.0));
        coupon.usedCoupon(LocalDateTime.now(), product, discount_price);
        return coupon;
    }

}
