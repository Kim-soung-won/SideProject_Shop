package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.EMBEDDED.Cart_key;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Domains.User.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Cart_key> {

    @Query("select c from Cart c join fetch c.key.product_id where c.key.user_id = ?1")
    List<Cart> findByUserId(UserInfo user);
}
