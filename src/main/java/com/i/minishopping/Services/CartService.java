package com.i.minishopping.Services;

import com.i.minishopping.Domains.Cart;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService{
    private final CartRepository cartRepository;

    @Transactional
    public Cart saveCart(Product product, int count, Created created){
        return cartRepository.save(Cart.builder()
                .product_id(product)
                .count(count)
                .created(created)
                .build());
    }

    @Transactional
    public void deleteCart(Long id){
        Cart cart = cartRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found : " + id));
        cartRepository.delete(cart);
    }
}

