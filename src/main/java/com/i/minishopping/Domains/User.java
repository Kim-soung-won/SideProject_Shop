package com.i.minishopping.Domains;

import com.i.minishopping.Config.CustomValidation.Password;
import com.i.minishopping.Domains.ENUM.ROLE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
    @Password
    private String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private ROLE role;

    @Column(name = "user_pnum")
    private String pnum;
}
