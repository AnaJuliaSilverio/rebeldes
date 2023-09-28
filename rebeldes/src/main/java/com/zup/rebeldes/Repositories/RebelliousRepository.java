package com.zup.rebeldes.Repositories;

import com.zup.rebeldes.Models.Rebellious;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RebelliousRepository extends JpaRepository<Rebellious,Long> {
    @Query("SELECT COUNT(r) FROM Rebellious r WHERE r.status = true")
    long countRebelsWithStatusTrue();
    @Query("SELECT COUNT(r) FROM Rebellious r WHERE r.status = false")
    long countRebelsWithStatusFalse();
}
