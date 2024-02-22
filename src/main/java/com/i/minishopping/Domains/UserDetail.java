package com.i.minishopping.Domains;

import com.i.minishopping.Domains.ENUM.SEX;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user_detail")
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    private String name;
    private int height;
    private int weight;
    private SEX sex;
}
