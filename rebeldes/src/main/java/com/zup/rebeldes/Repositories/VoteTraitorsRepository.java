package com.zup.rebeldes.Repositories;

import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Models.VoteTraitors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VoteTraitorsRepository extends JpaRepository<VoteTraitors, Long> {
    @Query("SELECT v FROM VoteTraitors v WHERE v.idRebel.id = :rebelId")
    Optional<VoteTraitors> findVoteTraitors(Long rebelId);
}
