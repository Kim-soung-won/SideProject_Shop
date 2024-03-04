package com.i.minishopping.Controllers.ApiController.Coupon;

import com.i.minishopping.DTO.Coupon.AddCouponRequest;
import com.i.minishopping.DTO.Coupon.UpdateCouponRequest;
import com.i.minishopping.Domains.Brands;
import com.i.minishopping.Domains.Coupon;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.User;
import com.i.minishopping.Services.BrandsService;
import com.i.minishopping.Services.CouponService;
import com.i.minishopping.Services.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CouponApiController {
    private final CouponService couponService;
    private final BrandsService brandsService;
    private final ProductService productService;
//    쿠폰 재발급 방지 로직 추가 필요할 듯
    @PostMapping("/api/POST/coupon")
    public ResponseEntity<Coupon> addCoupon(@RequestBody @Valid AddCouponRequest addCouponRequest, HttpSession session){
        String name = addCouponRequest.getName();
        int discount = addCouponRequest.getDiscount();
        Brands brands = brandsService.findByName(addCouponRequest.getBrandName());
        User user = (User) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Coupon coupon = couponService.saveCoupon(name, discount, brands, created);
        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }

    @PutMapping("/api/PUT/useCoupon")
    public ResponseEntity<Coupon> useCoupon(@RequestBody @Valid UpdateCouponRequest request){
        Coupon coupon = couponService.useCoupon(request);
        return ResponseEntity.ok().body(coupon);
    }
}
