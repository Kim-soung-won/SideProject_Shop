package com.i.minishopping.Repositorys;

import com.i.minishopping.Domains.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
