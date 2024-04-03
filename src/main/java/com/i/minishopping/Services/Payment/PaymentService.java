package com.i.minishopping.Services.Payment;


import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import com.i.minishopping.Domains.Payment.Delivery;
import com.i.minishopping.Domains.Payment.Payment;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Payment.PaymentRepository;
import com.i.minishopping.Services.Product.PdDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final DeliveryService deliveryService;
    private final PdDetailService pdDetailService;
    @Transactional
    public Payment savePayment(Created created, Product product, int count,
                               int total_price, String size, String th_pnum, String th_address){
        Payment payment = paymentRepository.save(Payment.builder()
                .created(created)
                .product(product)
                .count(count)
                .total_price(total_price)
                .size(size)
                .build());
        deliveryService.saveDelivery(payment, th_pnum, th_address);
        pdDetailService.sellCount(count, new Product_Detail_key(product, size));
        return payment;
    }

    public Payment findById(Long id){
        return paymentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found: " + id));
    }
}
