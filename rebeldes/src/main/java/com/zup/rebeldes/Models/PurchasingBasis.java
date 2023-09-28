package com.zup.rebeldes.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchasing_basis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasingBasis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
}
