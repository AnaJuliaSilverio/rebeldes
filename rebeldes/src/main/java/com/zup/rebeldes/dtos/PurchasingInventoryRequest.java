package com.zup.rebeldes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchasingInventoryRequest {
    @NotBlank
    private String name;
    @NotNull
    private int quantity;
}
