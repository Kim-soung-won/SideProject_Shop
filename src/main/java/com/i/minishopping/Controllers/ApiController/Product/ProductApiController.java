package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTO.Product.AddProductRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product;
import com.i.minishopping.Domains.User;
import com.i.minishopping.Services.ProductService;
import com.i.minishopping.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;
    private final UserService userService;

    @PostMapping("/api/POST/product")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid AddProductRequest request){
        User user = userService.findById(1L);
//        User user = userService.findById(authentication.getId());
        Created created = new Created(user, LocalDateTime.now());
        Product product = productService.saveOneProduct(request, created);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
