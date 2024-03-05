package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.ENUM.SEX;
import com.i.minishopping.Domains.User.User;
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
