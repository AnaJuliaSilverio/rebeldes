package com.zup.rebeldes.controllers;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory/{id}")
public class InventoryControllers {
    @Autowired
    InventoryService inventoryService;
    @PostMapping
    public ResponseEntity<Inventory> createInventory(@PathVariable(value = "id")Long id, @RequestBody Inventory inventory){
        Inventory inventory1 = inventoryService.createInventory(id, inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body(inventory1);
    }
    @PutMapping
    public ResponseEntity<Inventory> updateInventory(@PathVariable(value = "id")Long id, @RequestBody Inventory inventory){
        Inventory inventory1 = inventoryService.updateInventory(inventory);
        return ResponseEntity.ok().body(inventory1);
    }

}
