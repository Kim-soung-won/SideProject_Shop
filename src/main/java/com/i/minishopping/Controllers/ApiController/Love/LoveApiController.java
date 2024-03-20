package com.i.minishopping.Controllers.ApiController.Love;

import com.i.minishopping.DTO.Love.AddLoveRequest;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User.Love;
import com.i.minishopping.Domains.User.User;
import com.i.minishopping.Services.LoveService;
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
    public ResponseEntity<Love> clickLove(@RequestBody @Valid AddLoveRequest request, HttpSession session) {
        Product product = productService.findById(request.getProduct_id());
        User user = (User) session.getAttribute("user");
        Love love = loveService.clickLove(user, product);
        return ResponseEntity.ok().body(love);
    }
}
