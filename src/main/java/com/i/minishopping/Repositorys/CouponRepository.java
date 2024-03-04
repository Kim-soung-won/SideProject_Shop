package com.i.minishopping.Repositorys;

import com.i.minishopping.Domains.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
}
