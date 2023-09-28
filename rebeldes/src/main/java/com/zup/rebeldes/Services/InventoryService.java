package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Models.PurchasingBasis;
import com.zup.rebeldes.Models.PurchasingInventory;
import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Repositories.InventoryRepository;
import com.zup.rebeldes.Repositories.RebelliousRepository;
import com.zup.rebeldes.dtos.InventoryRequest;
import com.zup.rebeldes.dtos.InventoryResponse;
import com.zup.rebeldes.dtos.PurchasingInventoryRequest;
import com.zup.rebeldes.dtos.RebelliousRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private RebelliousService rebelliousService;
    @Autowired
    PurchasingBasisService purchasingBasisService;
    @Autowired
    private ModelMapper modelMapper;

    public InventoryResponse updateInventory(InventoryRequest inventoryRequest, Long id) {
        Inventory inventory= inventoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("inventário não encontrado"));
        Rebellious idRebel = inventory.getIdRebel();
        checksStatusRebel(idRebel.getId());
        List<PurchasingInventory> purchasingInventory = inventoryRequest.getPurchasingInventoryRequests().stream()
                .map(item -> new PurchasingInventory(inventory, purchasingBasisService.findByName(item.getName())))
                .toList();
        List<PurchasingInventory> purchasingInventories = inventory.getPurchasingInventories();
        purchasingInventories.addAll(purchasingInventory);
        inventory.setPurchasingInventories(purchasingInventory);

        return modelMapper.map(inventory,InventoryResponse.class);
    }

    public Inventory createInventory(RebelliousRequest rebelliousRequest) {
        Inventory inventory = new Inventory();
        List<PurchasingInventoryRequest> purchasingInventoryRequests = rebelliousRequest.getIdInventory().getPurchasingInventoryRequests();
        List<PurchasingInventory> purchasingInventory = purchasingInventoryRequests.stream()
                .map(item -> new PurchasingInventory(inventory, purchasingBasisService.findByName(item.getName()), item.getQuantity()))
                .toList();
        inventory.setPurchasingInventories(purchasingInventory);
        return inventoryRepository.save(inventory);
    }


    public void checksStatusRebel(Long idRebel){
        Rebellious rebellious = rebelliousService.findById(idRebel);
        if (rebellious.getStatus()) throw new IllegalArgumentException("Traidores não podem comprar");
    }
}
