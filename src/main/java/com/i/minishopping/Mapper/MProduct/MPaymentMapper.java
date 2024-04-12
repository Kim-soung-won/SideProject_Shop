package com.i.minishopping.Mapper.MProduct;

import com.i.minishopping.DTOResponse.Manage.PaymentListResponse;
import com.i.minishopping.Mapper.DTO.MPaymentSortAndOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MPaymentMapper {
    List<PaymentListResponse> getPaymentList(@Param("data") MPaymentSortAndOrder data);
}
