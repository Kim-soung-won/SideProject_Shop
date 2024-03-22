package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.ENUM.SEX;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user_info")
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User_account user;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "sex")
    private SEX sex;
}
