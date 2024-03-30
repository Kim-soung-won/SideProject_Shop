package com.i.minishopping.DTOResponse.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListResponse {
    private Long id;
    private String name;
    private String content;
    private LocalDateTime created_at;
    private List<String> url;
}
