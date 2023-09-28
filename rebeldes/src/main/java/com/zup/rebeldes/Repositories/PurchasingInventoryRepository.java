package com.zup.rebeldes.Repositories;

import com.zup.rebeldes.Models.PurchasingInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasingInventoryRepository extends JpaRepository<PurchasingInventory,Long> {
}
