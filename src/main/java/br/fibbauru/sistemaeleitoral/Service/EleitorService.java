package br.fibbauru.sistemaeleitoral.Service;

import br.fibbauru.sistemaeleitoral.Entity.Eleitor;
import br.fibbauru.sistemaeleitoral.Repository.EleitorRepository;
import org.springframework.stereotype.Service;

@Service
public class EleitorService {

    private final EleitorRepository eleitorRepository;

    public EleitorService(EleitorRepository eleitorRepository) {
        this.eleitorRepository = eleitorRepository;
    }

    public Eleitor cadastrarEleitor(Eleitor eleitor) {
        Eleitor eleitorExistente = eleitorRepository.findByRg(eleitor.getRg());
        if(eleitorExistente != null) {
            throw new IllegalArgumentException("Usuario ja existe!");
        }
        return eleitorRepository.save(eleitor);
    }
}
