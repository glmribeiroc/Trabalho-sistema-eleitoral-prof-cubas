package br.fibbauru.sistemaeleitoral.Repository;

import br.fibbauru.sistemaeleitoral.Entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Candidato findByNumero(int numero);
}
