package com.zup.rebeldes.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory")
@EqualsAndHashCode(of = "id")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn (name = "fk_rebel")
    private Rebellious idRebel;
    @OneToMany(mappedBy ="idInventory",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PurchasingInventory> purchasingInventories;
}
