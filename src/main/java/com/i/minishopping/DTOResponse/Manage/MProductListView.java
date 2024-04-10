package com.i.minishopping.DTOResponse.Manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MProductListView {
    private Long id;
    private String brandName;
    private String name;
    private int price;
    private Long amount;
    private Long sales;
}
