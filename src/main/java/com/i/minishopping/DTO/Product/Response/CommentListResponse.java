package com.i.minishopping.DTO.Product.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListResponse {
    private String name;
    private String content;
    private LocalDateTime created_at;
}
