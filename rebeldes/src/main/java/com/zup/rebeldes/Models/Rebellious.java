package com.zup.rebeldes.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    private Boolean status = false;
    @Column(nullable = false)
    private String location;
    @OneToOne(mappedBy = "idRebel",cascade=CascadeType.ALL)
    private Inventory idInventory;
    @OneToOne(mappedBy = "idRebel", cascade = CascadeType.ALL)
    private VoteTraitors voteTraitors;
    @JsonManagedReference
    public Inventory getIdInventory() {
        return idInventory;
    }
    @JsonManagedReference
    public VoteTraitors getVoteTraitors() {
        return voteTraitors;
    }
}
