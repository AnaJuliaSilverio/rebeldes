package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Repositories.InventoryRepository;
import com.zup.rebeldes.Repositories.RebelliousRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private RebelliousService rebelliousService;
    @Autowired
    RebelliousRepository repository;

    public Inventory createInventory(Long id, Inventory inventory) {
        Rebellious rebellious1 = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        inventory.setIdRebel(rebellious1);
        return inventoryRepository.save(inventory);
    }


    public Inventory updateInventory(Inventory inventory) {
        Inventory inventory1 = inventoryRepository.findById(inventory.getId()).orElseThrow(() -> new EntityNotFoundException("inventário não encontrado"));
        Rebellious idRebel = inventory1.getIdRebel();
        checksStatusRebel(idRebel.getId());
        inventory1.setPurchasingInventories(inventory.getPurchasingInventories());
        return inventory1;
    }
    public void checksStatusRebel(Long idRebel){
        Rebellious rebellious = rebelliousService.findById(idRebel);
        if (rebellious.getStatus()) throw new IllegalArgumentException("Traidores não podem comprar");
    }
}
