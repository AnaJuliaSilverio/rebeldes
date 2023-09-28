package com.zup.rebeldes.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "vote_traitors")
@EqualsAndHashCode(of = "id")
public class VoteTraitors {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn (name = "fk_rebel")
    private Rebellious idRebel;
    @Column (nullable = false)
    private int votes = 0;
    @JsonBackReference
    public Rebellious getIdRebel() {
        return idRebel;
    }
}
