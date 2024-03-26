package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.EMBEDDED.Cart_key;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Domains.User.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Cart_key> {

    @Query(value = "select * from cart where cart.created_who = ?1", nativeQuery = true)
    List<Cart> findByUserId(Long created_who);
}
