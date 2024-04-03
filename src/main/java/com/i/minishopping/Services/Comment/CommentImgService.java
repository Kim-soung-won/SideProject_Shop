package com.i.minishopping.Services.Comment;

import com.i.minishopping.Domains.Comment.CommentImg;
import com.i.minishopping.Repositorys.Comment.CommentImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentImgService {
    private final CommentImgRepository commentImgRepository;

    @Transactional
    public void upload(List<CommentImg> list) {
        commentImgRepository.saveAll(list);
    }
//    public void upload()
}
