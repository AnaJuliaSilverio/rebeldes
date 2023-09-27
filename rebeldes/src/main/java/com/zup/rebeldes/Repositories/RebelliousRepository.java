package com.zup.rebeldes.Repositories;

import com.zup.rebeldes.Models.Rebellious;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebelliousRepository extends JpaRepository<Rebellious,Long> {
}
