package com.i.minishopping.Controllers.ViewController.Product;

import com.i.minishopping.DTOResponse.Product.CommentListResponse;
import com.i.minishopping.Services.Comment.CommentViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentViewController {

    private final CommentViewService commentViewService;
    @PostMapping("/api/GET/commentList")
    public ResponseEntity<List<CommentListResponse>> getPopularList(
            @RequestParam(name="id", required = false) Long param){
        Pageable pageRange = PageRequest.of(0,10, Sort.by("created_at").descending());
        List<CommentListResponse> comments = commentViewService.findCommentList(param,pageRange);
        return ResponseEntity.ok(comments);
    }
}
