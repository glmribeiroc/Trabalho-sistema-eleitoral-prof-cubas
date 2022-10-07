package br.fibbauru.sistemaeleitoral.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Eleitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String rg;
    @Column(unique = true)
    private String tituloEleitor;

    @OneToOne(mappedBy = "eleitor")
    private Voto voto;
}
