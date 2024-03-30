package com.i.minishopping.Controllers.ApiController.Payment;

import com.i.minishopping.DTORequest.Coupon.AddCouponRequest;
import com.i.minishopping.DTORequest.Coupon.UpdateCouponRequest;
import com.i.minishopping.DTOResponse.Common.CommonResponse;
import com.i.minishopping.Domains.Payment.Coupon;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.Product.BrandService;
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
    private final BrandService brandsService;
    private final ProductService productService;
//    쿠폰 재발급 방지 로직 추가 필요할 듯
    @PostMapping("/api/POST/coupon") //쿠폰 등록 API
    public ResponseEntity<CommonResponse> addCoupon(@RequestBody @Valid AddCouponRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null){
            return ResponseEntity.ok().body(new CommonResponse(666,"로그인이 필요합니다."));
        }
        Created created = new Created(user, LocalDateTime.now());
        Coupon coupon = couponService.saveCoupon(
                request.getName(),
                request.getDiscount(),
                brandsService.findByName(request.getBrandName()),
                created);
        return ResponseEntity.ok().body(new CommonResponse(200,"쿠폰이 등록되었습니다."));
    }

    @PutMapping("/api/PUT/useCoupon") //쿠폰 사용 API
    public ResponseEntity<CommonResponse> useCoupon(@RequestBody @Valid UpdateCouponRequest request){
        Coupon coupon = couponService.useCoupon(request);
        return ResponseEntity.ok().body(new CommonResponse(200,"쿠폰이 사용되었습니다."));
    }
}
