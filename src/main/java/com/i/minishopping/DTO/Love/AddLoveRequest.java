package com.i.minishopping.DTO.Love;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddLoveRequest {
    private Long product_id;
    private Long user_id;
}
