package br.fibbauru.sistemaeleitoral.Service;

import br.fibbauru.sistemaeleitoral.DTO.VotoRequest;
import br.fibbauru.sistemaeleitoral.Entity.Candidato;
import br.fibbauru.sistemaeleitoral.Entity.Eleitor;
import br.fibbauru.sistemaeleitoral.Entity.Voto;
import br.fibbauru.sistemaeleitoral.Repository.CandidatoRepository;
import br.fibbauru.sistemaeleitoral.Repository.EleitorRepository;
import br.fibbauru.sistemaeleitoral.Repository.VotoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VotoService {

    private final EleitorRepository eleitorRepository;
    private final CandidatoRepository candidatoRepository;
    private final VotoRepository votoRepository;

    public VotoService(EleitorRepository eleitorRepository, CandidatoRepository candidatoRepository, VotoRepository votoRepository) {
        this.eleitorRepository = eleitorRepository;
        this.candidatoRepository = candidatoRepository;
        this.votoRepository = votoRepository;
    }

    public void votar(VotoRequest votoRequest) {
        Eleitor eleitor = eleitorRepository.findByRg(votoRequest.rg());

        if(eleitor == null) {
            throw new IllegalArgumentException("Eleitor não foi encontrado");
        }

        if (!votoRequest.tituloEleitor().equals(eleitor.getTituloEleitor())) {
            System.out.println(votoRequest.tituloEleitor() + " " + eleitor.getTituloEleitor());
            throw new IllegalArgumentException("Titulo de eleitor invalido");
        }

        Candidato candidato = candidatoRepository.findByNumero(votoRequest.numero());

        if(candidato == null) {
            throw new IllegalArgumentException("Candidato invalido");
        }

        Voto novoVoto = new Voto();
        novoVoto.setEleitor(eleitor);
        novoVoto.setCandidato(candidato);
        novoVoto.setVotado_em(new Date());

        votoRepository.save(novoVoto);
    }
}
