package com.i.minishopping.DTO.User;

import com.i.minishopping.Domains.ENUM.ROLE;
import com.i.minishopping.Domains.User.UserAccount;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
public class UserJoinRequest {
    private String email;
    private String password;
    private String pnum;

    public UserAccount toEntity(PasswordEncoder passwordEncoder){
        return UserAccount.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(ROLE.USER)
                .pnum(pnum)
                .build();
    }
}
