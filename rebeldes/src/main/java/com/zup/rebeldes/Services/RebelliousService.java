package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.*;
import com.zup.rebeldes.Repositories.RebelliousRepository;
import com.zup.rebeldes.dtos.InventoryRequest;
import com.zup.rebeldes.dtos.PurchasingInventoryRequest;
import com.zup.rebeldes.dtos.RebelliousRequest;
import com.zup.rebeldes.dtos.RebelliousResponse;
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

    public RebelliousResponse createNewRebellious(RebelliousRequest rebelliousRequest) {
        Inventory inventory = inventoryService.createInventory(rebelliousRequest);
        Rebellious rebellious = new Rebellious();
        VoteTraitors voteTraitors1 = new VoteTraitors();

        rebellious.setIdInventory(inventory);
        rebellious.setVoteTraitors(voteTraitors1);
        rebellious.setName(rebelliousRequest.getName());
        rebellious.setLocation(rebelliousRequest.getLocation());
        rebellious.setAge(rebelliousRequest.getAge());
        rebellious.setGender(rebelliousRequest.getGender());
        inventory.setIdRebel(rebellious);
        voteTraitors1.setIdRebel(rebellious);
        rebelliousRepository.save(rebellious);

        return modelMapper.map(rebellious, RebelliousResponse.class);
    }

    public List<RebelliousResponse> getAllRebellious() {
        return rebelliousRepository.findAll().stream()
                .map(rebellious -> modelMapper.map(rebellious,RebelliousResponse.class)).toList();
    }

    public RebelliousResponse updateRebellious(RebelliousResponse rebelliousResponse) {
        Rebellious rebellious = rebelliousRepository.findById(rebelliousResponse.getId()).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        rebellious.setLocation(rebelliousResponse.getLocation());
        rebelliousRepository.save(rebellious);
        return rebelliousResponse;
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
    public Double percentageOfTraitors(){
        long traitors = rebelliousRepository.countRebelsWithStatusTrue();
        long numberOfRebel= rebelliousRepository.count();
        return (double) ((traitors*100)/numberOfRebel);
    }
    public Double percentageOfRebel(){
        long rebels = rebelliousRepository.countRebelsWithStatusFalse();
        long numberOfRebel= rebelliousRepository.count();
        return (double) ((rebels*100)/numberOfRebel);
    }

}
