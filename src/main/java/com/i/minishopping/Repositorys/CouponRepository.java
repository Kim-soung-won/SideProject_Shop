package com.i.minishopping.Repositorys;

import com.i.minishopping.Domains.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Modifying
    @Query("UPDATE Coupon c SET c.used = true, c.used_at = :used_at, c.product_id = :product_id WHERE c.id = :id")
    void updateCoupon(Long id, Long product_id, LocalDateTime used_at);
}
