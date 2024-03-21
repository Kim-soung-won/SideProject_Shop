package com.i.minishopping.Domains.EMBEDDED;


import com.i.minishopping.Domains.User.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Created {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_who", referencedColumnName = "user_id")
    private Member created_who;

    @Column(name = "created_at")
    private LocalDateTime created_at;
}
