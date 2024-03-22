package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTO.Common.CommonResponse;
import com.i.minishopping.DTO.Love.AddLoveRequest;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User.Love;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.User.LoveService;
import com.i.minishopping.Services.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoveApiController {
    private final LoveService loveService;
    private final ProductService productService;


    @PutMapping("/api/PUT/love")
    public ResponseEntity<CommonResponse> clickLove(@RequestBody @Valid AddLoveRequest request, HttpSession session) {
        Product product = productService.findById(request.getProduct_id());
        UserInfo user = (UserInfo) session.getAttribute("user");
        Love love = loveService.clickLove(user, product);
        if(love == null) return ResponseEntity.ok().body(new CommonResponse(202,"좋아요 해제"));
        return ResponseEntity.ok().body(new CommonResponse(200,"좋아요!!"));
    }
}
