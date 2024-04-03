package com.i.minishopping.Controllers.ApiController.Payment;

import com.i.minishopping.DTORequest.Payment.AddPaymentRequest;
import com.i.minishopping.DTOResponse.Payment.PaymentResponse;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import com.i.minishopping.Domains.EMBEDDED.Product_log_key;
import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.Payment.Payment;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.Payment.PaymentService;
import com.i.minishopping.Services.Product.PdDetailService;
import com.i.minishopping.Services.Product.PdLogService;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.User.UserInfoService;
import com.i.minishopping.Services.User.UserLogService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentApiController {
    private final PaymentService paymentService;
    private final ProductService productService;
    private final PdDetailService pdDetailService;
    private final PdLogService pdLogService;
    private final UserLogService logService;


    @PostMapping("/api/POST/payment") // 결제 API
    public ResponseEntity<PaymentResponse> setPayment(@RequestBody @Valid AddPaymentRequest request,
                                                      HttpSession session
    ){
        Product product = productService.findById(request.getProduct_id());

        int count = request.getCount();
        int total_price = request.getTotal_price();
        String size = request.getSize();
        String th_pnum = request.getTh_pnum();
        String th_address = request.getTh_address();

        UserInfo user = (UserInfo) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());

        Payment payment = paymentService.savePayment(created,product,count,total_price, size,
                th_pnum, th_address);
        if(payment == null) return ResponseEntity.ok().body(
                new PaymentResponse(400, "데이터가 제대로 저장되지 않았습니다.", null, null, 0, 0));
        Product_Detail_key key = new Product_Detail_key(product, size);
        pdDetailService.sellCount(count, key);

        Product_log_key key2 = new Product_log_key(product, created);
        pdLogService.saveLog(key2, size, count*(-1));
        logService.saveUserLog(user.getId(), user.getName() , DOIT.PAYMENT);
        log.info(request.toString() + " : " + user.getName());
        PaymentResponse response = new PaymentResponse(200, "success", payment.getProduct_id().getName(),payment.getSize(), payment.getTotal_price(), payment.getCount());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
