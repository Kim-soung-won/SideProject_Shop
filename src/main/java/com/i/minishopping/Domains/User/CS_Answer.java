package com.i.minishopping.Domains.User;

import com.i.minishopping.Domains.EMBEDDED.Created;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cs_answer")
@NoArgsConstructor
@AllArgsConstructor
public class CS_Answer {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "cs_id")
    private CS cs;

    @Embedded
    private Created created;

    @Column(name = "content")
    private String content;

    @Builder
    public CS_Answer(CS cs, Created created, String content) {
        this.cs = cs;
        this.created = created;
        this.content = content;
    }
}
