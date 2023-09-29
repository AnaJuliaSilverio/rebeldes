package com.zup.rebeldes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RebelliousRequest {
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    @NotBlank
    private String gender;
    @NotBlank
    private String location;
    @NotNull
    private InventoryRequest idInventory;
}
