package com.i.minishopping.Services.Payment;


import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Payment.Payment;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment savePayment(Created created, Product product, int count,
                               int total_price, String size){
        return paymentRepository.save(Payment.builder()
                    .created(created)
                    .product(product)
                    .count(count)
                    .total_price(total_price)
                    .size(size)
                .build());
    }

    public Payment findById(Long id){
        return paymentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found: " + id));
    }
}
