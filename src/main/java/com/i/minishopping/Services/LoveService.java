package com.i.minishopping.Services;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Love;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User;
import com.i.minishopping.Repositorys.LoveRepository;
import com.i.minishopping.Services.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoveService {
    private final LoveRepository loveRepository;
    private final ProductService productService;
    public int countByUserId(Product product){
        return loveRepository.countByUserId(product);
    }
    @Transactional
    public Love findByLove(Product product, User created_who){
        Love love = loveRepository.findByLove(product, created_who);
        System.out.println("love = " + love);
        return love;
    }
    public Love findById(Long id) {
        Love love = loveRepository.findById(id).orElse(null);
        return love;
    }
    @Transactional
    public Love saveLove(Product product, Created created){
        return loveRepository.save(
                Love.builder()
                .product_id(product)
                .created(created)
                .build());
    }
    @Transactional
    public Love clickLove(HttpSession session) {
        Product product = productService.findById(23505L);
        User user = (User) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Love love = findByLove(product, user);
        if (love == null) {
            productService.count_Love(1, product.getProduct_id());
            return saveLove(product, created);
        } else {
            deleteLove(love.getId());
            productService.count_Love(-1, product.getProduct_id());
            return null;
        }
    }
    @Transactional
    public void deleteLove(Long id){
        Love love = loveRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        loveRepository.delete(love);
        long beforeTime = System.currentTimeMillis();
        System.out.println("DELETE : "+beforeTime);
    }
}
