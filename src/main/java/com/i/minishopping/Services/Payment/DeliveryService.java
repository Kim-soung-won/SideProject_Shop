package com.i.minishopping.Services.Payment;

import com.i.minishopping.Domains.ENUM.DLI_STATE;
import com.i.minishopping.Domains.Payment.Delivery;
import com.i.minishopping.Domains.Payment.Payment;
import com.i.minishopping.Repositorys.Payment.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;


    //결제 API와 함께 사용되서 해당 Service 단의 Transaction에 묶임
    public void saveDelivery(Payment payment, String tg_pnum, String tg_address){
        deliveryRepository.save(
                Delivery.builder()
                        .payment(payment)
                        .tg_pnum(tg_pnum)
                        .tg_address(tg_address)
                        .state(DLI_STATE.WAIT)
                        .created_at(LocalDateTime.now())
                        .build());
    }

    @Transactional
    public Delivery updateState(Delivery delivery, DLI_STATE state){
        delivery.updateState(state);
        return delivery;
    }

    @Transactional(readOnly = true)
    public Delivery findById(Long id){
        return deliveryRepository.findById(id).orElse(null);
    }
}
