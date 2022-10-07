package br.fibbauru.sistemaeleitoral.Controller;

import br.fibbauru.sistemaeleitoral.Entity.Candidato;
import br.fibbauru.sistemaeleitoral.Service.CandidatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Candidato> cadastrarCandidato(@RequestBody Candidato candidato) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(candidatoService.cadastrarCandidato(candidato));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/listar")
    public List<Candidato> listarCandidatos() {
        return candidatoService.listarCandidatos();
    }
}
