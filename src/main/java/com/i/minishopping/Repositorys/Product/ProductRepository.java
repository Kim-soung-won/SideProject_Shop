package com.i.minishopping.Repositorys.Product;

import com.i.minishopping.Domains.Product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("update Product set count_love = count_love+(:val) where product_id = :id")
    void updateCount(int val, Long id);

    @Query(value = "select * from product where pd_category like concat('%',:category,'%')", nativeQuery = true)
    Optional<List<Product>> findByCategory(Pageable pageable, String category);

    @Query(value = "select * from product order by count_love DESC", nativeQuery = true)
    Optional<List<Product>> findAllByPage(Pageable pageable);

    @Query(value = "select * from product", nativeQuery = true)
    Optional<List<Product>> findSortList(Pageable pageable);

    @Query(value = "select * from product order by created_at DESC", nativeQuery = true)
    Optional<List<Product>> findLatestList(Pageable pageable);

    @Query(value = "select * from product order by pd_price DESC", nativeQuery = true)
    Optional<List<Product>> findHighPriceList(Pageable pageable);

    @Query(value = "select * from product order by pd_price ASC", nativeQuery = true)
    Optional<List<Product>> findLowPriceList(Pageable pageable);
}
