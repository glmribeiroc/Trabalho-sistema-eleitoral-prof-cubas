package br.fibbauru.sistemaeleitoral.Repository;

import br.fibbauru.sistemaeleitoral.DTO.CandidatosResultadoResponse;
import br.fibbauru.sistemaeleitoral.Entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VotoRepository extends JpaRepository<Voto, Long> {

    @Query("SELECT NEW br.fibbauru.sistemaeleitoral.DTO.CandidatosResultadoResponse(v.candidato, COUNT(*) as TOTAL) FROM Voto v GROUP BY v.candidato ORDER BY TOTAL DESC")
    List<CandidatosResultadoResponse> buscarResultados();
}
