package com.i.minishopping.DTO.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddCSRequest {
    private String category;
    private String content;
}
