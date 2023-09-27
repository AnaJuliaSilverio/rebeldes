package com.zup.rebeldes.Repositories;

import com.zup.rebeldes.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
