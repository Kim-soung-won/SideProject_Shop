package com.i.minishopping.Repositorys.Comment;


import com.i.minishopping.Domains.Comment.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select * from comment c where c.product_id = :product_id", nativeQuery = true)
    List<Comment> getCommentList(Long product_id, Pageable page);
}
