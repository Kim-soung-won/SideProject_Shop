package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTO.Common.CommonResponse;
import com.i.minishopping.DTO.Product.Request.AddCommentRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Comment;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.Product.CommentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PdCommentApiController {
    private final CommentService commentService;

    @PostMapping("/api/POST/comment")
    private ResponseEntity<CommonResponse> saveComment(@RequestBody @Valid AddCommentRequest request
    , HttpSession session){
        System.out.println("11111111111111111111111111");
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user==null){
            return ResponseEntity.ok().body(new CommonResponse(666,"로그인이 필요합니다."));
        }
        Created created = new Created(user, LocalDateTime.now());
        Comment comment = commentService.saveComment(request, created);
        return ResponseEntity.ok().body(new CommonResponse(200,"댓글이 등록되었습니다."));
    }
}
