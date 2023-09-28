package com.zup.rebeldes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryRequest {
    private Set<PurchasingInventoryRequest> purchasingInventoryRequests;
}
