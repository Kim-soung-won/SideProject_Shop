package com.i.minishopping.Controllers.ApiController.Comment;

import com.i.minishopping.Controllers.ApiController.Storage.UploadImages;
import com.i.minishopping.DTORequest.Comment.DeleteCommentRequest;
import com.i.minishopping.DTOResponse.Common.CommonResponse;
import com.i.minishopping.DTORequest.Comment.AddCommentRequest;
import com.i.minishopping.Domains.Comment.CommentImg;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Comment.Comment;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.Comment.CommentImgService;
import com.i.minishopping.Services.Comment.CommentService;
import com.i.minishopping.Services.Storage.NCPObjectStorageService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;
    private final UploadImages uploadImages;

    @PostMapping("/api/POST/comment") //댓글 작성 API (프론트 연동 완료)
    private ResponseEntity<CommonResponse> saveComment(@RequestParam("product_id") Long product_id,
                                                         @RequestParam("content") String content,
                                                            @RequestParam("images") List<MultipartFile> images,
                                                       HttpSession session){
        AddCommentRequest request = new AddCommentRequest(product_id, content, images);
        UserInfo user = (UserInfo) session.getAttribute("user");
        System.out.println("겟이미지=-=-=-=-=-=-="+request.getImages());
        if(user==null){
            return ResponseEntity.ok().body(new CommonResponse(666,"로그인이 필요합니다."));
        }
        Created created = new Created(user, LocalDateTime.now());
        Comment comment = commentService.saveComment(request, created);

        uploadImages.commentUploadImages(request.getImages(), comment);
        
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
        return ResponseEntity.ok().body(new CommonResponse(202,"댓글이 삭제되었습니다."));
    }
}
