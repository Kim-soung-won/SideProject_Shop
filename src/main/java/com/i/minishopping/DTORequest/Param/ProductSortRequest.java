package com.i.minishopping.DTORequest.Param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSortRequest {
    private int id;
    private String name;
    private int paging;

}
