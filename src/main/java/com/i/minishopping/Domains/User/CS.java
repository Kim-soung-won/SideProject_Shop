package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.ENUM.CS_STATE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "customer_service")
@NoArgsConstructor
@AllArgsConstructor
public class CS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_id")
    private Long id;

    @Embedded
    private Created created;

    @Column(name = "category")
    private String category;

    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private CS_STATE state;

    @Builder
    public CS(Created created,String category, String content, CS_STATE state) {
        this.created = created;
        this.category = category;
        this.content = content;
        this.state = state;
    }

    public void updateState(CS_STATE state){
        this.state = state;
    }
}
