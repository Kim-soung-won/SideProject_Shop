package com.i.minishopping.DTOResponse.Manage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Getter
@Mapper
@NoArgsConstructor
@AllArgsConstructor
public class MBrandListResponse {
    private Long brand_id;
    private String name;
    private String sales;
    private int count;
}