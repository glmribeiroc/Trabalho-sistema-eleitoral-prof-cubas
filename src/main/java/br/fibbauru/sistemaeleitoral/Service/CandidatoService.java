package br.fibbauru.sistemaeleitoral.Service;

import br.fibbauru.sistemaeleitoral.Entity.Candidato;
import br.fibbauru.sistemaeleitoral.Repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public Candidato cadastrarCandidato(Candidato candidato) {
        Candidato candidatoExistente = candidatoRepository.findByNumero(candidato.getNumero());
        if(candidatoExistente != null) {
            throw new IllegalArgumentException("Candidato ja esta cadastrado!");
        }
        return candidatoRepository.save(candidato);
    }

    public List<Candidato> listarCandidatos() {
        return candidatoRepository.findAll();
    }
}
