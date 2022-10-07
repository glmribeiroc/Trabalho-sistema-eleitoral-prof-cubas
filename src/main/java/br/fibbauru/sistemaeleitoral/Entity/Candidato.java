package br.fibbauru.sistemaeleitoral.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String partido;
    @Column(unique = true)
    private int numero;

    @OneToMany(mappedBy = "candidato")
    private List<Voto> votos;
}
