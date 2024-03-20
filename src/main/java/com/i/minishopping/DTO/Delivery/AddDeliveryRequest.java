package com.i.minishopping.DTO.Delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddDeliveryRequest {
    private Long paymentId;
    private String tg_pnum;
    private String tg_address;
}
