package com.zup.rebeldes.dtos;

import lombok.*;

import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryRequest {
    private List<PurchasingInventoryRequest> purchasingInventoryRequests;
}
