package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTORequest.Cart.AddCartRequest;
import com.i.minishopping.DTOResponse.Cart.CartResponse;
import com.i.minishopping.DTORequest.Cart.DeleteCartRequest;
import com.i.minishopping.DTOResponse.Common.CommonResponse;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.User.CartService;
import com.i.minishopping.Services.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CartApiController {
    private final CartService cartService;
    private final ProductService productService;


    @PostMapping("/api/POST/cart")
    public ResponseEntity<CartResponse> addCart(@RequestBody @Valid AddCartRequest request,
                                                HttpSession session){
        System.out.println("cart");
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null){
            return ResponseEntity.ok().body(new CartResponse(666, "로그인이 필요합니다.", ""));
        }
        Long product_id = request.getProduct_id();
        String size = request.getSize();
        Cart cart = cartService.saveCart(user, product_id, size, request.getCount());
        CartResponse response = new CartResponse(400, "상품이 존재하지 않습니다.", "");
        if(cart == null){
            log.error("not found : Product and size");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(cart.getCount() != request.getCount()) {
            response = new CartResponse(201, "장바구니에 추가되었습니다. 기존 상품 수량이 증가되었습니다.", cart.getKey().getProduct_id().getName());
            log.info("add cart count"+cart.getKey().getProduct_id().getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        response = new CartResponse(200, "장바구니에 추가되었습니다.", cart.getKey().getProduct_id().getName());
        log.info("create cart"+cart.getKey().getProduct_id().getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("/api/DELETE/cart")
    public ResponseEntity<CommonResponse> deleteCart(@RequestBody @Valid DeleteCartRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        int status = cartService.deleteCart(user, request.getProduct_id(), request.getSize());
        if(status == 400){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResponse(status, "장바구니에 상품이 존재하지 않습니다."));
        }
        return ResponseEntity.ok().body(new CommonResponse(status, "장바구니에서 삭제되었습니다."));
    }
}
