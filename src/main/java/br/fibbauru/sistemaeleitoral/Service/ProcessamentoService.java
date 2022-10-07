package br.fibbauru.sistemaeleitoral.Service;

import br.fibbauru.sistemaeleitoral.DTO.CandidatosResultadoResponse;
import br.fibbauru.sistemaeleitoral.Repository.VotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessamentoService {

    private final VotoRepository votoRepository;

    public ProcessamentoService(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    public List<CandidatosResultadoResponse> buscarResultados() {
        return votoRepository.buscarResultados();
    }
}
