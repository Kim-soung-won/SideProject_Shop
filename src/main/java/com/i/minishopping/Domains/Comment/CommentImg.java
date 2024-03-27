package com.i.minishopping.Domains.Comment;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="comment_img")
@NoArgsConstructor
@Getter
public class CommentImg {
    @Id
    @Column(name = "img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_id")
    private Comment comment_id;

    @Column(name = "img_url")
    private String url;

    @Column(name = "img_name")
    private String name;

    @Builder
    public CommentImg(Comment comment_id, String url, String name){
        this.comment_id = comment_id;
        this.url = url;
        this.name = name;
    }
}
