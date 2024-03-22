package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.EMBEDDED.Cart_key;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cart")
@NoArgsConstructor
public class Cart {

    @EmbeddedId
    private Cart_key key;

    @Column(name = "count")
    private int count;

    @Builder
    public Cart(Cart_key key, int count){
        this.key = key;
        this.count = count;
    }

    public Cart addCount(int count){
        this.count += count;
        return this;
    }
}
