package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.*;
import com.zup.rebeldes.Repositories.RebelliousRepository;
import com.zup.rebeldes.dtos.InventoryRequest;
import com.zup.rebeldes.dtos.PurchasingInventoryRequest;
import com.zup.rebeldes.dtos.RebelliousRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RebelliousService {
    @Autowired
    VoteTraitorsService voteTraitors;
    @Autowired
    RebelliousRepository rebelliousRepository;
    @Lazy
    @Autowired
    InventoryService inventoryService;

    @Autowired
    private ModelMapper modelMapper;

    public Rebellious createNewRebellious(RebelliousRequest rebelliousRequest) {
        Inventory inventory = inventoryService.createInventory(rebelliousRequest);
        Rebellious rebellious = new Rebellious();
        rebellious.setIdInventory(inventory);
        rebellious.setName(rebelliousRequest.getName());
        rebellious.setLocation(rebelliousRequest.getLocation());
        rebellious.setAge(rebelliousRequest.getAge());
        rebellious.setGender(rebelliousRequest.getGender());
        return rebelliousRepository.save(rebellious);
    }

    public List<Rebellious> getAllRebellious() {
        return rebelliousRepository.findAll();
    }

    public Rebellious updateRebellious(Rebellious rebellious) {
        Rebellious rebellious1 = rebelliousRepository.findById(rebellious.getId()).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        rebellious1.setLocation(rebellious.getLocation());
        return rebelliousRepository.save(rebellious1);
    }
    public Rebellious findById(Long id){
        return rebelliousRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
    }

    public void reportRebellius(Long idReport, Long idRebellious){
        rebelliousRepository.findById(idReport).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        Rebellious beingReported = rebelliousRepository.findById(idRebellious).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        voteTraitors.increaseVotes(idRebellious);
        VoteTraitors voteTraitors1 = voteTraitors.getVoteTraitors(idRebellious);
        if (voteTraitors1.getVotes() == 3){
            setStatus(beingReported);
        }
    }
    public void setStatus(Rebellious rebellious){
        rebellious.setStatus(true);
        rebelliousRepository.save(rebellious);
    }

}
