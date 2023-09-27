package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Models.VoteTraitors;
import com.zup.rebeldes.Repositories.RebelliousRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebelliousService {
    @Autowired
    VoteTraitorsService voteTraitors;
    @Autowired
    RebelliousRepository rebelliousRepository;

    public Rebellious createNewRebellious(Rebellious rebellious) {
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
