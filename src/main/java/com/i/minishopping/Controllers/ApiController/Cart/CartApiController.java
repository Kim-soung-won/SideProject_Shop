package com.i.minishopping.Controllers.ApiController.Cart;

import com.i.minishopping.DTO.Cart.AddCartRequest;
import com.i.minishopping.DTO.Cart.DeleteCartRequest;
import com.i.minishopping.Domains.EMBEDDED.Cart_key;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User.User;
import com.i.minishopping.Services.CartService;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CartApiController {
    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;

    @PostMapping("/api/POST/cart")
    public ResponseEntity<Cart> addCart(@RequestBody @Valid AddCartRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        Cart_key key = new Cart_key(user,
                productService.findById(request.getProduct_id()),
                request.getSize());
        Cart cart = cartService.saveCart(key, request.getCount());
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }
//    {
    //    "product_id" : 23501,
    //    "user_id" : 1,
    //    "count" : 10
//    }

    @DeleteMapping("/api/DELETE/cart")
    public void deleteCart(@RequestBody @Valid DeleteCartRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        Cart_key key = new Cart_key(user,
                productService.findById(request.getProduct_id()),
                request.getSize());
        cartService.deleteCart(key);
    }
}
