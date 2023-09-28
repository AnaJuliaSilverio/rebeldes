package com.zup.rebeldes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchasingBasisResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private double price;
}
