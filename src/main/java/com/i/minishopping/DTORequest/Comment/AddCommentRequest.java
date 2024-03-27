package com.i.minishopping.DTORequest.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentRequest {
    private Long product_id;
    private String content;
    private List<MultipartFile> images;
}
