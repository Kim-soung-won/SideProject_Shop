package com.i.minishopping.Services.Comment;

import com.i.minishopping.DTORequest.Comment.AddCommentRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Comment.Comment;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Comment.CommentRepository;
import com.i.minishopping.Services.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductService productService;

    @Transactional
    public Comment saveComment(AddCommentRequest request, Created created) {
        Product product = productService.findById(request.getProduct_id());
        return commentRepository.save(Comment.builder()
                .product_id(product)
                .created(created)
                .content(request.getContent())
                .build());
    }

    @Transactional
    public void deleteComment(Long comment_id) {
        commentRepository.deleteById(comment_id);
    }
}
