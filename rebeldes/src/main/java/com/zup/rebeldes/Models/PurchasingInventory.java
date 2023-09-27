package com.zup.rebeldes.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchasing_inventory")
@EqualsAndHashCode(of = "id")
public class PurchasingInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "fk_inventory")
    private Inventory idInventory;
    @ManyToOne
    @JoinColumn (name = "fk_purchasing_basis")
    private PurchasingBasis idPurchasingBasis;
    @Column (nullable = false)
    private int quantity;
}
