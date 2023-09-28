package com.zup.rebeldes.dtos;

import com.zup.rebeldes.Models.PurchasingInventory;
import com.zup.rebeldes.Models.Rebellious;

import java.util.Set;

public class InventoryResponse {
    private Long id;
    private Rebellious idRebel;
    private Set<PurchasingInventory> purchasingInventories;
}
