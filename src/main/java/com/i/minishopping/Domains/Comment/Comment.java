package com.i.minishopping.Domains.Comment;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product_id;

    @Embedded
    private Created created;

    @Column(name = "content",nullable = false)
    private String content;

    @Builder
    public Comment(Product product_id, Created created, String content) {
        this.product_id = product_id;
        this.created = created;
        this.content = content;
    }
}
