package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.ENUM.DOIT;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="user_log")
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userlog_id")
    private Long id;

    @Column(name = "created_who")
    private Long user_id;

    @Column(name = "doit")
    @Enumerated(EnumType.STRING)
    private DOIT doit;

    @Builder
    private UserLog(Long user_id, DOIT doit){
        this.user_id = user_id;
        this.doit = doit;
    }
}
