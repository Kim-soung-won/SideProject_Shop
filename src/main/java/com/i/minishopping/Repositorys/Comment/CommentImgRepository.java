package com.i.minishopping.Repositorys.Comment;

import com.i.minishopping.Domains.Comment.CommentImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentImgRepository extends JpaRepository<CommentImg, Long> {

    @Query(value = "SELECT img_url FROM comment_img WHERE comment_id = ?1", nativeQuery = true)
    List<String> findImgUrlByCommentId(Long comment_id);
}
