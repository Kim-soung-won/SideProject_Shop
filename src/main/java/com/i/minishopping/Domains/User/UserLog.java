package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.ENUM.DOIT;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="user_log")
@NoArgsConstructor
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userlog_id")
    private Long id;

    @Column(name = "created_who")
    private Long user_id;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "doit")
    @Enumerated(EnumType.STRING)
    private DOIT doit;


    @Builder
    private UserLog(Long user_id, LocalDateTime created_at , DOIT doit){
        this.user_id = user_id;
        this.created_at = created_at;
        this.doit = doit;
    }
}
