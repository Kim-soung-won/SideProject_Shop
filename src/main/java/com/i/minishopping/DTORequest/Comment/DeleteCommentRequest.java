package com.i.minishopping.DTORequest.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCommentRequest {
    private Long comment_id;
    private String created_who;
}
