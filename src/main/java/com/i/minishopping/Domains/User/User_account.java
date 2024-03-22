package com.i.minishopping.Domains.User;

//import com.i.minishopping.Config.CustomValidation.Password;
import com.i.minishopping.Domains.ENUM.ROLE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_account")
@NoArgsConstructor
@AllArgsConstructor
public class User_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
//    @Password
    private String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private ROLE role;

    @Column(name = "user_pnum")
    private String pnum;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Builder
    public User_account(String email, String password, ROLE role, String pnum) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.pnum = pnum;
    }

    public void updateLastLogin(LocalDateTime lastLogin){
        this.lastLogin = lastLogin;
    }
}
