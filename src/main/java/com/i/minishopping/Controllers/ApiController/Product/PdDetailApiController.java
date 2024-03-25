package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTO.Common.CommonResponse;
import com.i.minishopping.DTO.Product.Request.AddPdDetailRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import com.i.minishopping.Domains.EMBEDDED.Product_log_key;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.Product.ProductDetail;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.Product.PdDetailService;
import com.i.minishopping.Services.Product.PdLogService;
import com.i.minishopping.Services.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PdDetailApiController {
    private final PdDetailService pdDetailService;
    private final ProductService productService;
    private final PdLogService pdLogService;

    @PostMapping("/api/POST/productDetail")
    public ResponseEntity<CommonResponse> saveProductDetail(@RequestBody @Valid
                                                           AddPdDetailRequest request, HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user==null){
            return ResponseEntity.ok().body(new CommonResponse(400, "로그인이 필요합니다"));
        }
        Product product = productService.findById(request.getProduct_id());
        if(product == null){
            return ResponseEntity.ok().body(new CommonResponse(400, "상품이 존재하지 않습니다"));
        }
        Created created = new Created(user, LocalDateTime.now());
        Product_Detail_key key = new Product_Detail_key(product, request.getSize());
        Product_log_key logkey = new Product_log_key(product, created);
        pdLogService.saveLog(logkey, request.getSize(), request.getBeforeCount());
        ProductDetail productDetail = pdDetailService.save(key, request.getBeforeCount());
        return ResponseEntity.ok().body(new CommonResponse(200, "상품이 추가되었습니다."));
    }
}
