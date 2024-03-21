package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTO.Cart.AddCartRequest;
import com.i.minishopping.DTO.Cart.DeleteCartRequest;
import com.i.minishopping.Domains.EMBEDDED.Cart_key;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Domains.User.Member;
import com.i.minishopping.Services.User.CartService;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.User.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CartApiController {
    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;

    @PostMapping("/api/POST/cart")
    public ResponseEntity<AddCartRequest> addCart(@RequestBody @Valid AddCartRequest request, HttpSession session){
        Member user = (Member) session.getAttribute("user");
        Cart_key key = new Cart_key(user,
                productService.findById(request.getProduct_id()),
                request.getSize());
        Cart cart = cartService.saveCart(key, request.getCount());
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
//    {
    //    "product_id" : 23501,
    //    "user_id" : 1,
    //    "count" : 10
//    }

    @DeleteMapping("/api/DELETE/cart")
    public void deleteCart(@RequestBody @Valid DeleteCartRequest request, HttpSession session){
        Member user = (Member) session.getAttribute("user");
        Cart_key key = new Cart_key(user,
                productService.findById(request.getProduct_id()),
                request.getSize());
        cartService.deleteCart(key);
    }
}
