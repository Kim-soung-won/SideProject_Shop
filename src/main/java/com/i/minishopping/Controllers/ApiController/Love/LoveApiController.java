package com.i.minishopping.Controllers.ApiController.Love;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Love;
import com.i.minishopping.Domains.Product;
import com.i.minishopping.Domains.User;
import com.i.minishopping.Services.LoveService;
import com.i.minishopping.Services.ProductService;
import com.i.minishopping.Services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class LoveApiController {
    private final LoveService loveService;
    private final ProductService productService;

    @PutMapping("/api/PUT/love")
    @Transactional
    public void clickLove(HttpSession session) {
        Product product = productService.findById(23505L);
        User user = (User) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Love love = loveService.findByLove(product, user);
        if (love == null) {
            loveService.saveLove(product, created);
            productService.count_Love(1, product.getId());
        } else {
            loveService.deleteLove(love.getId());
            productService.count_Love(-1, product.getId());
        }
    }
}
