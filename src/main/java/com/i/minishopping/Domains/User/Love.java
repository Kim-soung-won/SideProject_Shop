package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.EMBEDDED.Love_key;
import com.i.minishopping.Domains.EMBEDDED.Product_log_key;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "love")
@NoArgsConstructor
public class Love {

    @EmbeddedId
    private Love_key love_key;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Builder
    public Love(Love_key love_key, LocalDateTime created_at){
        this.love_key = love_key;
        this.created_at = created_at;
    }
}
