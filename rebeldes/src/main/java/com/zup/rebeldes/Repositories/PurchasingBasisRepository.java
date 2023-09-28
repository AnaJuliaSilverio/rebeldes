package com.zup.rebeldes.Repositories;

import com.zup.rebeldes.Models.PurchasingBasis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchasingBasisRepository extends JpaRepository<PurchasingBasis,Long> {
    Optional<PurchasingBasis> findByName(String name);
}
