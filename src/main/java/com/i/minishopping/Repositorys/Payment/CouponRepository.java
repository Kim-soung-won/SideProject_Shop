package com.i.minishopping.Repositorys.Payment;

import com.i.minishopping.Domains.Payment.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
}
