package com.i.minishopping.Controllers.ApiController.Comment;

import com.i.minishopping.DTORequest.Comment.DeleteCommentRequest;
import com.i.minishopping.DTOResponse.Common.CommonResponse;
import com.i.minishopping.DTORequest.Comment.AddCommentRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Comment.Comment;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.Comment.CommentService;
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
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping("/api/POST/comment") //댓글 작성 API (프론트 연동 완료)
    private ResponseEntity<CommonResponse> saveComment(@RequestBody @Valid AddCommentRequest request
    , HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user==null){
            return ResponseEntity.ok().body(new CommonResponse(666,"로그인이 필요합니다."));
        }

//        String filepath

        Created created = new Created(user, LocalDateTime.now());
        Comment comment = commentService.saveComment(request, created);
        return ResponseEntity.ok().body(new CommonResponse(200,"댓글이 등록되었습니다."));
    }

    @PostMapping("/api/DELETE/comment") //댓글 삭제 API (프론트 연동 완료)
    private ResponseEntity<CommonResponse> deleteComment(@RequestBody @Valid DeleteCommentRequest request,
                                                         HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        System.out.println(request.getCreated_who());
        if(user==null || !user.getName().equals(request.getCreated_who())){
            return ResponseEntity.ok().body(new CommonResponse(666,"작성자만 댓글을 지울 수 있습니다."));
        }
        commentService.deleteComment(request.getComment_id());
        return ResponseEntity.ok().body(new CommonResponse(200,"댓글이 삭제되었습니다."));
    }
}
