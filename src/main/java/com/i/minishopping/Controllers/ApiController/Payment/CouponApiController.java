package com.i.minishopping.Controllers.ApiController.Payment;

import com.i.minishopping.DTO.Coupon.AddCouponRequest;
import com.i.minishopping.DTO.Coupon.UpdateCouponRequest;
import com.i.minishopping.Domains.Payment.Coupon;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.User.User;
import com.i.minishopping.Services.Product.BrandsService;
import com.i.minishopping.Services.Payment.CouponService;
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
    public ResponseEntity<AddCouponRequest> addCoupon(@RequestBody @Valid AddCouponRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Coupon coupon = couponService.saveCoupon(
                request.getName(),
                request.getDiscount(),
                brandsService.findByName(request.getBrandName()),
                created);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PutMapping("/api/PUT/useCoupon")
    public ResponseEntity<UpdateCouponRequest> useCoupon(@RequestBody @Valid UpdateCouponRequest request){
        Coupon coupon = couponService.useCoupon(request);
        return ResponseEntity.ok().body(request);
    }
}
