package com.i.minishopping.Repositorys;

import com.i.minishopping.Domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query("update Product set count_love = count_love+(:val) where id = :id")
    void updateCount(int val, Long id);

}
