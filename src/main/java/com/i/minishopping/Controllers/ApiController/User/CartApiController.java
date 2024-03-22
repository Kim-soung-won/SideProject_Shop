package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTO.Cart.AddCartRequest;
import com.i.minishopping.DTO.Cart.CartResponse;
import com.i.minishopping.DTO.Cart.DeleteCartRequest;
import com.i.minishopping.DTO.Common.CommonResponse;
import com.i.minishopping.Domains.EMBEDDED.Cart_key;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Domains.User.Member;
import com.i.minishopping.Services.User.CartService;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.User.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CartApiController {
    private final CartService cartService;
    private final ProductService productService;
    private final Logger logger = LoggerFactory.getLogger(SpringApplication.class);


    @PostMapping("/api/POST/cart")
    public ResponseEntity<CartResponse> addCart(@RequestBody @Valid AddCartRequest request
//            , Authentication authentication
    ){
//        String email = authentication.getName();
        String email = "hello@naver.com";
        Long product_id = request.getProduct_id();
        String size = request.getSize();
        Cart cart = cartService.saveCart(email, product_id, size, request.getCount());
        CartResponse response = new CartResponse(400, "상품이 존재하지 않습니다.", "");
        if(cart == null){
            logger.error("not found : Product and size");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response = new CartResponse(200, "장바구니에 추가되었습니다.", cart.getKey().getProduct_id().getName());
        if(cart.getCount() != request.getCount()) {
            response = new CartResponse(201, "장바구니에 추가되었습니다. 기존 상품 수량이 증가되었습니다.", cart.getKey().getProduct_id().getName());
            logger.info("add cart count"+cart.getKey().getProduct_id().getName());
        }
        logger.info("create cart"+cart.getKey().getProduct_id().getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("/api/DELETE/cart")
    public ResponseEntity<CommonResponse> deleteCart(@RequestBody @Valid DeleteCartRequest request){
        int status = cartService.deleteCart("hello@naver.com", request.getProduct_id(), request.getSize());
        if(status == 400){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResponse(status, "장바구니에 상품이 존재하지 않습니다."));
        }
        return ResponseEntity.ok().body(new CommonResponse(status, "장바구니에서 삭제되었습니다."));
    }
}
