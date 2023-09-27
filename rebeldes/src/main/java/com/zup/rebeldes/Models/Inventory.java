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
@Entity(name = "inventory")
@Table(name = "inventory")
@EqualsAndHashCode(of = "id")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn (name = "fk_rebel")
    private Rebellious idRebel;
    @OneToMany(mappedBy = "inventory",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PurchasingInventory> purchasingInventories;
}
