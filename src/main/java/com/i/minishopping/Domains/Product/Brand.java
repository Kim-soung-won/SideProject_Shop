package com.i.minishopping.Domains.Product;

import com.i.minishopping.Domains.EMBEDDED.Created;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brand_id;

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brand_name;

    @Embedded
    private Created created;
    @Builder
    public Brand(String brand_name, Created created){
        this.brand_name = brand_name;
        this.created = created;
    }
}
