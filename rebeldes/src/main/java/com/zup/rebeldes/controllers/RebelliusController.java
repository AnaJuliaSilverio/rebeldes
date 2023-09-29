package com.zup.rebeldes.controllers;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Services.RebelliousService;
import com.zup.rebeldes.dtos.RebelliousRequest;
import com.zup.rebeldes.dtos.RebelliousResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rebel")
public class RebelliusController {
    @Autowired
    RebelliousService service;
    @PostMapping
    public ResponseEntity<RebelliousResponse> createRebel(@RequestBody RebelliousRequest rebellious){
        RebelliousResponse rebelliousResponse = service.createNewRebellious(rebellious);
        return ResponseEntity.status(HttpStatus.CREATED).body(rebelliousResponse);
    }

    @PutMapping
    public ResponseEntity<RebelliousResponse> updateRebel(@RequestBody RebelliousResponse rebellious){
        return ResponseEntity.ok(service.updateRebellious(rebellious));
    }
    @GetMapping
    public ResponseEntity<List<RebelliousResponse>> getAllRebelious(){
        return ResponseEntity.ok(service.getAllRebellious());
    }
    @PostMapping("/{idReport}")
    public ResponseEntity<Rebellious> reportRebelious(@PathVariable(value = "idReport")Long id, @RequestBody Map<String, Long> requestBody){
        Long beingReported = requestBody.get("beingReported");
        service.reportRebellius(id,beingReported);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/percentage-of-traitors")
    public ResponseEntity getPercentageTraitors(){
        return ResponseEntity.ok(service.percentageOfTraitors());
    }
    @GetMapping("/percentage-of-rebels")
    public ResponseEntity getPercentageRebel(){
        return ResponseEntity.ok(service.percentageOfRebel());
    }


}
