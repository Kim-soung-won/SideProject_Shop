package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.EMBEDDED.Cart_key;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Repositorys.User.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService{
    private final CartRepository cartRepository;

    @Transactional
    public Cart saveCart(Cart_key key, int count){
        return cartRepository.save(Cart.builder()
                .key(key)
                .count(count)
                .build());
    }

    @Transactional
    public void deleteCart(Cart_key key){
        Cart cart = cartRepository.findById(key)
                .orElseThrow(()->new IllegalArgumentException("not found : Cart"));
        cartRepository.delete(cart);
    }
}

