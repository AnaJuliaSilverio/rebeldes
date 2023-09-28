package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Models.PurchasingBasis;
import com.zup.rebeldes.Models.PurchasingInventory;
import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Repositories.InventoryRepository;
import com.zup.rebeldes.Repositories.RebelliousRepository;
import com.zup.rebeldes.dtos.PurchasingInventoryRequest;
import com.zup.rebeldes.dtos.RebelliousRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private RebelliousService rebelliousService;
    @Autowired
    PurchasingBasisService purchasingBasisService;

    public Inventory updateInventory(Inventory inventory) {
        Inventory inventory1 = inventoryRepository.findById(inventory.getId()).orElseThrow(() -> new EntityNotFoundException("inventário não encontrado"));
        Rebellious idRebel = inventory1.getIdRebel();
        checksStatusRebel(idRebel.getId());
        inventory1.setPurchasingInventories(inventory.getPurchasingInventories());
        return inventory1;
    }
    public Inventory createInventory(RebelliousRequest rebelliousRequest){
        Set<PurchasingInventoryRequest> inventoryRequests = rebelliousRequest.getIdInventory().getPurchasingInventoryRequests();
        Set<PurchasingInventory> purchasingInventory = inventoryRequests.stream()
                .map(item -> new PurchasingInventory(purchasingBasisService.findByName(item.getName()), item.getQuantity())).collect(Collectors.toSet());
        Inventory inventory = new Inventory();
        inventory.setPurchasingInventories(purchasingInventory);
        return inventory;
    }
    public void checksStatusRebel(Long idRebel){
        Rebellious rebellious = rebelliousService.findById(idRebel);
        if (rebellious.getStatus()) throw new IllegalArgumentException("Traidores não podem comprar");
    }
}
