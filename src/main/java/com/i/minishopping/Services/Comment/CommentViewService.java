package com.i.minishopping.Services.Comment;

import com.i.minishopping.DTOResponse.Product.CommentListResponse;
import com.i.minishopping.Domains.Comment.Comment;
import com.i.minishopping.Domains.Comment.CommentImg;
import com.i.minishopping.Repositorys.Comment.CommentImgRepository;
import com.i.minishopping.Repositorys.Comment.CommentRepository;
import com.i.minishopping.Services.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentViewService {
    private final CommentRepository commentRepository;
    private final CommentImgRepository commentImgRepository;
    private final ProductService productService;

    @Transactional
    public List<CommentListResponse> findCommentList(Long id, Pageable page){
        List<Comment> comments = commentRepository.getCommentList(id, page);
        System.out.println("service : "+ comments);
        List<CommentListResponse> commentList = comments.stream()
                .map(data -> new CommentListResponse(
                        data.getComment_id(),
                        data.getCreated().getCreated_who().getName(),
                        data.getContent(),
                        data.getCreated().getCreated_at(),
                        findUrl(data.getImages())
                ))
                .toList();
        return commentList;
    }
    public List<String> findUrl(List<CommentImg> images){
//        for(int i=0; i<images.size(); i++){
//            url.add(images.get(i).getUrl());
//        }
        return images.stream().map(CommentImg::getUrl).toList();
    }
}
