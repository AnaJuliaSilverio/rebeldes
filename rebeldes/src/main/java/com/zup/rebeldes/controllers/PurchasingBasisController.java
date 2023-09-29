package com.zup.rebeldes.controllers;

import com.zup.rebeldes.Models.PurchasingBasis;
import com.zup.rebeldes.Services.PurchasingBasisService;
import com.zup.rebeldes.dtos.PurchasingBasisRequest;
import com.zup.rebeldes.dtos.PurchasingBasisResponse;
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
    public ResponseEntity<PurchasingBasisResponse> createPurchasing(@RequestBody PurchasingBasisRequest purchasingBasis){
        PurchasingBasisResponse purchasingBasis1 = purchasingBasisService.create(purchasingBasis);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchasingBasis1);
    }
    @GetMapping
    public ResponseEntity<List<PurchasingBasisResponse>> getAllPurchasing(){
        List<PurchasingBasisResponse> purchasingBasisList = purchasingBasisService.getAlls();
        return ResponseEntity.ok(purchasingBasisList);
    }
}
