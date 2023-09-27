package com.zup.rebeldes.Repositories;

import com.zup.rebeldes.Models.PurchasingBasis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasingBasisRepository extends JpaRepository<PurchasingBasis,Long> {
}
