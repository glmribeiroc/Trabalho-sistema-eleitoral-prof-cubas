package br.fibbauru.sistemaeleitoral.DTO;

import br.fibbauru.sistemaeleitoral.Entity.Candidato;

public class CandidatosResultadoResponse {

    private String candidato;
    private Long totalVotos;

    public CandidatosResultadoResponse(Candidato candidato, Long totalVotos) {
        this.candidato = candidato.getNome();
        this.totalVotos = totalVotos;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public Long getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Long totalVotos) {
        this.totalVotos = totalVotos;
    }
}
