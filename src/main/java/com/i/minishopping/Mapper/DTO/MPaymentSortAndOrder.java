package com.i.minishopping.Mapper.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MPaymentSortAndOrder {
    String name;
    int paging;
    int pagingSize;
}