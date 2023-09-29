package com.zup.rebeldes.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
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
    private List<PurchasingInventory> purchasingInventories;
    @JsonBackReference
    public Rebellious getIdRebel() {
        return idRebel;
    }
    @JsonManagedReference
    public List<PurchasingInventory> getPurchasingInventories() {
        return purchasingInventories;
    }
}
