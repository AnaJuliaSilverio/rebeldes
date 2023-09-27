package com.zup.rebeldes.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "rebel")
@Table(name = "rebel")
@EqualsAndHashCode(of = "id")
public class Rebellious {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private Boolean status;
    @Column(nullable = false)
    private String location;
    @OneToOne
    @JoinColumn (name = "fk_Inventory")
    private Inventory idInventory;

}
