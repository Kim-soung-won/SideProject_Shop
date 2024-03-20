package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTO.Product.AddCommentRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Comment;
import com.i.minishopping.Domains.User.User;
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
    private ResponseEntity<AddCommentRequest> saveComment(@RequestBody @Valid AddCommentRequest request
    , HttpSession session){
        User user = (User) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Comment comment = commentService.saveComment(request, created);
        return ResponseEntity.ok().body(request);
    }
}
