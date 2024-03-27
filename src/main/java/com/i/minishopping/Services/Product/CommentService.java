package com.i.minishopping.Services.Product;

import com.i.minishopping.DTORequest.Product.AddCommentRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Comment;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Product.PdCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PdCommentRepository pdCommentRepository;
    private final ProductService productService;

    @Transactional
    public Comment saveComment(AddCommentRequest request, Created created) {
        Product product = productService.findById(request.getProduct_id());
        return pdCommentRepository.save(Comment.builder()
                .product_id(product)
                .created(created)
                .content(request.getContent())
                .build());
    }
}
