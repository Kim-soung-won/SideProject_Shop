package com.i.minishopping.Mapper.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserAccountBatis {
    private Long user_id;
    private String user_email;
    private String user_password;
    private String user_pnum;
    private UserRole user_role;
    private LocalDateTime last_login;

    public enum UserRole {
        USER, MANAGER, ADMIN

    }

    @Builder
    public UserAccountBatis(String user_email, String user_password, String user_pnum, UserRole user_role, LocalDateTime last_login) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_pnum = user_pnum;
        this.user_role = user_role;
        this.last_login = last_login;
    }
}
