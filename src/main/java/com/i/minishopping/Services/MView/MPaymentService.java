package com.i.minishopping.Services.MView;

import com.i.minishopping.DTOResponse.Manage.PaymentListResponse;
import com.i.minishopping.Mapper.DTO.MPaymentSortAndOrder;
import com.i.minishopping.Mapper.MProduct.MPaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MPaymentService {
    private final MPaymentMapper mapper;

    public List<PaymentListResponse> getPaymentList(MPaymentSortAndOrder data){
        return mapper.getPaymentList(data);
    }
}