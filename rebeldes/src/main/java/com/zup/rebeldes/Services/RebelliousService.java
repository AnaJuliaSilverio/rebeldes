package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Models.VoteTraitors;
import com.zup.rebeldes.Repositories.RebelliousRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class RebelliousService {
    @Autowired
    VoteTraitorsService voteTraitors;
    @Autowired
    RebelliousRepository repository;
    @Autowired
    InventoryService inventoryService;

    public Rebellious createNewRebellious(Rebellious rebellious, Inventory inventory) {
        Rebellious save = repository.save(rebellious);
        voteTraitors.createVoteTraitors(save);
        inventory.setIdRebel(save);
        Inventory inventory1 = inventoryService.createInventory(save.getId(), inventory);
        save.setIdInventory(inventory1);
        return save;
    }

    public List<Rebellious> getAllRebellious() {
        return repository.findAll();
    }

    public Rebellious updateRebellious(Rebellious rebellious) {
        Rebellious rebellious1 = repository.findById(rebellious.getId()).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        rebellious1.setLocation(rebellious.getLocation());
        return repository.save(rebellious1);
    }
    public Rebellious findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
    }

    public void reportRebellius(Long idReport, Long idRebellious){
        Rebellious report = repository.findById(idReport).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        Rebellious beingReported = repository.findById(idRebellious).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        voteTraitors.increaseVotes(idRebellious);
        VoteTraitors voteTraitors1 = voteTraitors.getVoteTraitors(idRebellious);
        if (voteTraitors1.getVotes() == 3){
            setStatus(beingReported);
        }
    }
    public void setStatus(Rebellious rebellious){
        rebellious.setStatus(true);
        repository.save(rebellious);
    }

}
