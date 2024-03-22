package com.i.minishopping.DTO.User;

import com.i.minishopping.Domains.ENUM.ROLE;
import com.i.minishopping.Domains.User.User_account;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
public class UserJoinRequest {
    private String email;
    private String password;
    private String pnum;

    public User_account toEntity(PasswordEncoder passwordEncoder){
        return User_account.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(ROLE.USER)
                .pnum(pnum)
                .build();
    }
}
