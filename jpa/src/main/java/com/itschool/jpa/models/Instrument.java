package com.itschool.jpa.models;

import com.itschool.jpa.enums.InstrumentCategory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "instrument")
@Data
@NoArgsConstructor
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private InstrumentCategory category;
    private String manufacturer;
    @Column(nullable = false)
    private int stockQuantity;


}
