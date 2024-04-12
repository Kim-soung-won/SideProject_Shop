package com.i.minishopping.DTOResponse.Manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentListResponse {
    private Long payment_id;
    private Long user_id;
    private String user_name;
    private Long product_id;
    private String size;
    private int count;
    private String state;
    private LocalDateTime time;
}