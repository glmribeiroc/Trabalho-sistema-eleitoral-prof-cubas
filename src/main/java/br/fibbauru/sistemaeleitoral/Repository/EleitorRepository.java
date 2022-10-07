package br.fibbauru.sistemaeleitoral.Repository;

import br.fibbauru.sistemaeleitoral.Entity.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
    Eleitor findByRg(String rg);
}
