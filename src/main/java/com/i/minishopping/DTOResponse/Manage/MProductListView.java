package com.i.minishopping.DTOResponse.Manage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MProductListView {
    private Long id;
    private String brand;
    private String name;
    private int price;
    private Long amount;
    private Long sum;
}
