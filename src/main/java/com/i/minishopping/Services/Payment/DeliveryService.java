package com.i.minishopping.Services.Payment;

import com.i.minishopping.DTORequest.Delivery.AddDeliveryRequest;
import com.i.minishopping.Domains.ENUM.DLI_STATE;
import com.i.minishopping.Domains.Payment.Delivery;
import com.i.minishopping.Repositorys.Payment.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final PaymentService paymentService;

    @Transactional
    public Delivery saveDelivery(AddDeliveryRequest request){
        return deliveryRepository.save(
                Delivery.builder()
                        .payment(paymentService.findById(request.getPaymentId()))
                        .tg_pnum(request.getTg_pnum())
                        .tg_address(request.getTg_address())
                        .state(DLI_STATE.WAIT)
                        .created_at(LocalDateTime.now())
                        .build());
    }

    @Transactional
    public Delivery updateState(Long id, DLI_STATE state){
        Delivery delivery = findById(id);
        delivery.updateState(state);
        return delivery;
    }
    public Delivery findById(Long id){
        return deliveryRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found: " + id));
    }
}
