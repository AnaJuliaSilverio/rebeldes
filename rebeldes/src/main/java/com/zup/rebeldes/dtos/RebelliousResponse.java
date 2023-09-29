package com.zup.rebeldes.dtos;

import com.zup.rebeldes.Models.Inventory;
import com.zup.rebeldes.Models.VoteTraitors;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RebelliousResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    @NotBlank
    private String gender;
    @NotBlank
    private String location;
    @NotNull
    private Inventory idInventory;
    @NotNull
    private VoteTraitors voteTraitors;
}
