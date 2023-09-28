package com.zup.rebeldes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RebelliousRequest {

    private String name;
    private Integer age;
    private String gender;
    private String location;
    private InventoryRequest idInventory;
}
