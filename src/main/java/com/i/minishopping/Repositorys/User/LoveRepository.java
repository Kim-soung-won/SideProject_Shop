package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.EMBEDDED.Love_key;
import com.i.minishopping.Domains.User.Love;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Domains.User.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoveRepository extends JpaRepository<Love, Love_key> {
    @Query("SELECT COUNT(l) FROM Love l WHERE l.love_key.product_id = ?1")
    int countByUserId(Product product_id);

    @Query("SELECT l FROM Love l WHERE l.love_key.product_id = ?1 AND l.love_key.created_who = ?2")
    Love findByLove(Product product_id, UserAccount created_who);


    @Query(value = "select * from love where love.created_who = ?1", nativeQuery = true)
    List<Love> findByUserId(Long created_who);

}
