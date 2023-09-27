package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.Rebellious;
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

    public Rebellious createNewRebellious(Rebellious rebellious) {
        Rebellious save = repository.save(rebellious);
        voteTraitors.createVoteTraitors(save);
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

//    public void reportRebellius(Long idReport, Long idRebellious){
//
//    }

}
