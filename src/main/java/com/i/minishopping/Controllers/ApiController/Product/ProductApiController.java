package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTORequest.Product.AddProductRequest;
import com.i.minishopping.DTORequest.Product.DeleteProductRequest;
import com.i.minishopping.DTORequest.Product.UpdateProductRequest;
import com.i.minishopping.DTOResponse.Product.ProductDeleteResponse;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.User.UserInfoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;
    private final UserInfoService userService;

    @PostMapping("/api/POST/product") // 상품 추가 API
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid AddProductRequest request,
                                               HttpSession session){
        UserInfo info = (UserInfo) session.getAttribute("user");
        Created created = new Created(info, LocalDateTime.now());
        Product product = productService.saveOneProduct(request, created);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("/api/DELETE/product") //상품 삭제 API
    public ResponseEntity<ProductDeleteResponse> deleteProduct(@RequestBody DeleteProductRequest request){
        Product product = productService.deleteOneProduct(request.getProduct_id());
        ProductDeleteResponse response = new ProductDeleteResponse(200, "success", product.getProduct_id(), product.getName());
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/api/PUT/product") //상품 수정 API 카테고리, 가격, 이름 등
    public ResponseEntity<UpdateProductRequest> updateProduct(@RequestBody UpdateProductRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Product product = productService.updateOneProduct(request, created);
        return ResponseEntity.ok().body(request);
    }
}
