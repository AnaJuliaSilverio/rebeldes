package com.zup.rebeldes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchasingInventoryRequest {
    @NotBlank
    private String name;
    @NotNull
    private int quantity;
}
