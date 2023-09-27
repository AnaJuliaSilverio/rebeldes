package com.zup.rebeldes.controllers;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory/{id}")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    @PutMapping
    public ResponseEntity<Inventory> updateInventory(@PathVariable(value = "id")Long id, @RequestBody Inventory inventory){
        Inventory inventory1 = inventoryService.updateInventory(inventory);
        return ResponseEntity.ok().body(inventory1);
    }

}
