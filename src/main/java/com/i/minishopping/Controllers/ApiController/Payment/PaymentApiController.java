package com.i.minishopping.Controllers.ApiController.Payment;

import com.i.minishopping.DTO.Payment.AddPaymentRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Payment;
import com.i.minishopping.Domains.Product;
import com.i.minishopping.Domains.User;
import com.i.minishopping.Services.PaymentService;
import com.i.minishopping.Services.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PaymentApiController {
    private final PaymentService paymentService;
    private final ProductService productService;

    @PostMapping("/api/POST/payment")
    public ResponseEntity<Payment> setPayment(@RequestBody @Valid AddPaymentRequest request, HttpSession session){
        Product product = productService.findById(request.getProduct_id());
        int basic_price = request.getBasic_price();
        int discount = request.getDiscount();
        int total_price = request.getTotal_price();
        User user = (User) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Payment payment = paymentService.savePayment(created,product,basic_price,discount,total_price);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
