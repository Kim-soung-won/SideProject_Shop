package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.ENUM.SEX;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "user_info")
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserAccount user;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private SEX sex;

}
