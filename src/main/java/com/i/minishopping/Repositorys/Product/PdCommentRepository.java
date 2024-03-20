package com.i.minishopping.Repositorys.Product;


import com.i.minishopping.Domains.Product.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PdCommentRepository extends JpaRepository<Comment, Long> {
}
