package com.zup.rebeldes.controllers;

import com.zup.rebeldes.Models.PurchasingBasis;
import com.zup.rebeldes.Services.PurchasingBasisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchasing")
public class PurchasingBasisController {
    @Autowired
    private PurchasingBasisService purchasingBasisService;

    @PostMapping
    public ResponseEntity<PurchasingBasis> createPurchasing(@RequestBody PurchasingBasis purchasingBasis){
        PurchasingBasis purchasingBasis1 = purchasingBasisService.create(purchasingBasis);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchasingBasis1);
    }
    @GetMapping
    public ResponseEntity<List<PurchasingBasis>> getAllPurchasing(){
        List<PurchasingBasis> purchasingBasisList = purchasingBasisService.getAlls();
        return ResponseEntity.ok(purchasingBasisList);
    }
}
