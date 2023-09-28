package com.zup.rebeldes.controllers;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Services.RebelliousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rebel")
public class RebelliusController {
    @Autowired
    RebelliousService service;
    @PostMapping
    public ResponseEntity<Rebellious> createRebel(@RequestBody Rebellious rebellious){
        Rebellious rebellious1 = service.createNewRebellious(rebellious);
        return ResponseEntity.status(HttpStatus.CREATED).body(rebellious1);
    }

    @PutMapping
    public ResponseEntity<Rebellious> updateRebel(@RequestBody Rebellious rebellious){
        Rebellious rebellious1 = service.updateRebellious(rebellious);
        return ResponseEntity.ok(rebellious1);
    }
    @GetMapping
    public ResponseEntity<List<Rebellious>> getAllRebelious(){
        return ResponseEntity.ok(service.getAllRebellious());
    }
    @PostMapping("/{idReport}")
    public ResponseEntity<Rebellious> reportRebelious(@PathVariable(value = "idReport")Long id, @RequestBody Long beingReported){
        service.reportRebellius(id,beingReported);
        return ResponseEntity.ok().build();
    }



}
