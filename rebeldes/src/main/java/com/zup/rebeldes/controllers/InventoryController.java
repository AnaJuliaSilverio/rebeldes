package com.zup.rebeldes.controllers;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Services.InventoryService;
import com.zup.rebeldes.dtos.InventoryRequest;
import com.zup.rebeldes.dtos.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory/{id}")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    @PutMapping("/{idInventory}")
    public ResponseEntity<InventoryResponse> updateInventory(@PathVariable(value = "id")Long id, @PathVariable(value = "idInventory")Long idInventory, @RequestBody InventoryRequest inventoryRequest) {
        InventoryResponse inventoryResponse = inventoryService.updateInventory(inventoryRequest,idInventory);
        return ResponseEntity.ok().body(inventoryResponse);
    }

}
