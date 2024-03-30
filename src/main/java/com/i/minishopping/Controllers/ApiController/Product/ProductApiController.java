package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTORequest.Product.AddProductRequest;
import com.i.minishopping.DTORequest.Product.DeleteProductRequest;
import com.i.minishopping.DTORequest.Product.UpdateProductRequest;
import com.i.minishopping.DTOResponse.Common.CommonResponse;
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
    public ResponseEntity<CommonResponse> saveProduct(@RequestBody @Valid AddProductRequest request,
                                                      HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user==null){
            return ResponseEntity.ok().body(new CommonResponse(666, "로그인이 필요합니다"));
        }
        Created created = new Created(user, LocalDateTime.now());
        Product product = productService.saveOneProduct(request, created);
        if(product == null){
            return ResponseEntity.ok().body(new CommonResponse(400, "등록에 실패했습니다."));
        }
        return ResponseEntity.ok().body(new CommonResponse(200, "등록됐음!"));
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
