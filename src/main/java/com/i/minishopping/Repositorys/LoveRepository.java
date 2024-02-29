package com.i.minishopping.Repositorys;

import com.i.minishopping.Domains.Love;
import com.i.minishopping.Domains.Product;
import com.i.minishopping.Domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoveRepository extends JpaRepository<Love, Long> {
    @Query("SELECT COUNT(l) FROM Love l WHERE l.product_id = ?1")
    int countByUserId(Product product_id);

    @Query("SELECT l FROM Love l WHERE l.product_id = ?1 AND l.created.created_who = ?2")
    Love findByLove(Product product_id, User created_who);


}
