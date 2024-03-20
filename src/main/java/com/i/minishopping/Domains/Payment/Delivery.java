package com.i.minishopping.Domains.Payment;

import com.i.minishopping.Domains.ENUM.DLI_STATE;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false, unique = true)
    private Payment payment;

    @Column(name = "tg_pnum", nullable = false)
    private String tg_pnum;

    @Column(name = "tg_address", nullable = false)
    private String tg_address;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private DLI_STATE state;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Builder
    public Delivery(Payment payment, String tg_pnum, String tg_address, DLI_STATE state, LocalDateTime created_at) {
        this.payment = payment;
        this.tg_pnum = tg_pnum;
        this.tg_address = tg_address;
        this.state = state;
        this.created_at = created_at;
    }

    public void updateState(DLI_STATE state){
        this.state = state;
        this.updated_at = LocalDateTime.now();
    }
}

