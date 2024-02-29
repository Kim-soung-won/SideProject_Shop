package com.i.minishopping.Repositorys;

import com.i.minishopping.Domains.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
