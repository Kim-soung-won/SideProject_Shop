package com.i.minishopping.Services.Product;

import com.i.minishopping.DTO.Product.Response.CommentListResponse;
import com.i.minishopping.Domains.Product.Comment;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Product.PdCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentViewService {
    private final PdCommentRepository commentRepository;
    private final ProductService productService;

    @Transactional
    public List<CommentListResponse> findCommentList(Long id, Pageable page){
        List<Comment> comments = commentRepository.getCommentList(id, page);
        System.out.println("service : "+ comments);
        List<CommentListResponse> commentList = comments.stream()
                .map(data -> new CommentListResponse(data.getCreated().getCreated_who().getName(),
                        data.getContent(),data.getCreated().getCreated_at()))
                .toList();
        return commentList;
    }
}
