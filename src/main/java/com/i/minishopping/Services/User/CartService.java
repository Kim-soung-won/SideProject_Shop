package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.EMBEDDED.Cart_key;
import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.Product.ProductDetail;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Domains.User.Member;
import com.i.minishopping.Domains.User.UserLog;
import com.i.minishopping.Repositorys.User.CartRepository;
import com.i.minishopping.Services.Product.PdDetailService;
import com.i.minishopping.Services.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService{
    private final Logger logger = LoggerFactory.getLogger(SpringApplication.class);
    private final CartRepository cartRepository;
    private final PdDetailService pdDetailService;
    private final ProductService productService;
    private final UserService userService;

    @Transactional
    public Cart saveCart(String email, Long id, String size , int count){
        Product product = productService.findById(id);
        Product_Detail_key detailKey = new Product_Detail_key(product, size);
        ProductDetail pdDetail = pdDetailService.findById(detailKey);
        if(pdDetail == null){
            logger.error("not found : Product and size");
            throw new IllegalArgumentException("not found : ProductDetail");
        }
        Member user = userService.findByEmail(email);
        Cart_key key = new Cart_key(user, product, size);
        Cart cart = cartRepository.findById(key).orElse(null);
        if(cart == null){
            logger.info("create cart who : " + email);
            return cartRepository.save(Cart.builder()
                    .key(key)
                    .count(count)
                    .build());
        }
        return addCount(cart, count);
    }

    @Transactional
    public Cart addCount(Cart cart, int count){
        return cart.addCount(count);
    }

    @Transactional
    public void deleteCart(Cart_key key){
        Cart cart = cartRepository.findById(key)
                .orElseThrow(()->new IllegalArgumentException("not found : Cart"));
        cartRepository.delete(cart);
    }
}

