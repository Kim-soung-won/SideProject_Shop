package com.i.minishopping.Domains.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "user_info")
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserAccount user;

    @Column(name = "name", unique = true)
    private String name;

    @Builder
    public UserInfo(UserAccount user, String name) {
        this.user = user;
        this.name = name;
    }
}
