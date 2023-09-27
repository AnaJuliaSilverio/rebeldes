package com.zup.rebeldes.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vote_traitors")
@Table(name = "vote_traitors")
@EqualsAndHashCode(of = "id")
public class VoteTraitors {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn (name = "fk_rebel")
    private Rebellious idRebel;
    @Column (nullable = false)
    private int votes = 0;
}
