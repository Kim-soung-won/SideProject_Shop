package com.i.minishopping.Controllers.ApiController.Love;

import com.i.minishopping.Domains.Love;
import com.i.minishopping.Services.LoveService;
import com.i.minishopping.Services.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoveApiController {
    private final LoveService loveService;
    private final ProductService productService;

    @PutMapping("/api/PUT/love")
    public ResponseEntity<Love> clickLove(HttpSession session) {
        Love love = loveService.clickLove(session);
        return ResponseEntity.ok().body(love);
    }
}
