package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.VoteTraitors;
import com.zup.rebeldes.Repositories.VoteTraitorsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteTraitorsService {
    @Autowired
    private VoteTraitorsRepository voteTraitorsRepository;

    public void increaseVotes(Long id){
        VoteTraitors voteTraitors = voteTraitorsRepository.findVoteTraitors(id).orElseThrow(() -> new EntityNotFoundException("Tabela não encontrado"));
        voteTraitors.setVotes(voteTraitors.getVotes()+1);
        voteTraitorsRepository.save(voteTraitors);
    }

    public VoteTraitors getVoteTraitors(Long id){
        return voteTraitorsRepository.findVoteTraitors(id).orElseThrow(() -> new EntityNotFoundException("Tabela não encontrado"));
    }
}
