package com.i.minishopping.DTOResponse.Manage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MProductDetailView {
    private Long id;
    private String name;
    private int price;
    private String brandName;
    private int count_love;
    private String category;
    private List<detailsObject> details;
}


