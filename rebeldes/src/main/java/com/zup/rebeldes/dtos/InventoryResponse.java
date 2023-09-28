package com.zup.rebeldes.dtos;

import com.zup.rebeldes.Models.PurchasingInventory;
import com.zup.rebeldes.Models.Rebellious;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryResponse {
    private Long id;
    private Rebellious idRebel;
    private Set<PurchasingInventory> purchasingInventories;
}
