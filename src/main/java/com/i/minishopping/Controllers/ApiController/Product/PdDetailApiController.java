package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTO.Product.AddPdDetailRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import com.i.minishopping.Domains.EMBEDDED.Product_log_key;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.Product.ProductDetail;
import com.i.minishopping.Domains.User.User;
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
    public ResponseEntity<AddPdDetailRequest> saveProductDetail(@RequestBody @Valid
                                                           AddPdDetailRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Product product = productService.findById(request.getProduct_id());
        Created created = new Created(user, LocalDateTime.now());
        Product_Detail_key key = new Product_Detail_key(product, request.getSize());
        Product_log_key logkey = new Product_log_key(product, created);
        pdLogService.saveLog(logkey, request.getSize(), request.getBeforeCount());
        ProductDetail productDetail = pdDetailService.save(key, request.getBeforeCount());
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
