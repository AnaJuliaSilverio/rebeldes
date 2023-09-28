package com.zup.rebeldes.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn (name = "fk_inventory")
    private Inventory idInventory;
    @ManyToOne
    @JoinColumn (name = "fk_purchasing_basis")
    private PurchasingBasis idPurchasingBasis;
    @Column (nullable = false)
    private int quantity;
    @JsonBackReference
    public Inventory getIdInventory() {
        return idInventory;
    }

    public PurchasingInventory(Inventory idInventory, PurchasingBasis idPurchasingBasis, int quantity) {
        this.idInventory = idInventory;
        this.idPurchasingBasis = idPurchasingBasis;
        this.quantity = quantity;
    }
    public PurchasingInventory(Inventory idInventory, PurchasingBasis idPurchasingBasis) {
        this.idInventory = idInventory;
        this.idPurchasingBasis = idPurchasingBasis;

    }
}
