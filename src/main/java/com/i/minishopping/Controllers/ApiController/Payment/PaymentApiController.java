package com.i.minishopping.Controllers.ApiController.Payment;

import com.i.minishopping.DTO.Payment.AddPaymentRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import com.i.minishopping.Domains.EMBEDDED.Product_log_key;
import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.Payment.Payment;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User.User;
import com.i.minishopping.Services.Payment.PaymentService;
import com.i.minishopping.Services.Product.PdDetailService;
import com.i.minishopping.Services.Product.PdLogService;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.User.UserLogService;
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
    private final PdDetailService pdDetailService;
    private final PdLogService pdLogService;
    private final UserLogService log;

    @PostMapping("/api/POST/payment")
    public ResponseEntity<AddPaymentRequest> setPayment(@RequestBody @Valid AddPaymentRequest request, HttpSession session){
        Product product = productService.findById(request.getProduct_id());

        int count = request.getCount();
        int total_price = request.getTotal_price();
        String size = request.getSize();

        User user = (User) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());

        Payment payment = paymentService.savePayment(created,product,count,total_price, size);

        Product_Detail_key key = new Product_Detail_key(product, size);
        pdDetailService.sellCount(count, key);

        Product_log_key key2 = new Product_log_key(product, created);
        pdLogService.saveLog(key2, size, count*(-1));
        log.saveUserLog(user.getId(), DOIT.PAYMENT);

        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
