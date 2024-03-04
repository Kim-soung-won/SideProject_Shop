package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTO.Product.AddProductRequest;
import com.i.minishopping.DTO.Product.DeleteProductRequest;
import com.i.minishopping.DTO.Product.UpdateProductRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;
    private final UserService userService;

    @PostMapping("/api/POST/product")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid AddProductRequest request, HttpSession session){
        System.out.println("USER : "+ session.getAttribute("user"));
        User user = (User) session.getAttribute("user");
//        User user = userService.findById(authentication.getId());
        Created created = new Created(user, LocalDateTime.now());
        Product product = productService.saveOneProduct(request, created);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
//        {
//            "name" : "test1",
//                "price" : 55000,
//                "brandName" : "Apple",
//                "category" : "testCategory1",
//                "beforeCount" : 10
//        }
    }

    @DeleteMapping("/api/DELETE/product")
    public void deleteProduct(@RequestBody DeleteProductRequest request){
        productService.deleteOneProduct(request.getProduct_id());
    }

    @PutMapping("/api/PUT/product")
    public ResponseEntity<Product> updateProduct(@RequestBody UpdateProductRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Product product = productService.updateOneProduct(request, created);
        return ResponseEntity.ok().body(product);
    }
}
