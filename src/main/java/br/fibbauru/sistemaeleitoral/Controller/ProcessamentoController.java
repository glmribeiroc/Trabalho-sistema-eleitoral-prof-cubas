package br.fibbauru.sistemaeleitoral.Controller;

import br.fibbauru.sistemaeleitoral.DTO.CandidatosResultadoResponse;
import br.fibbauru.sistemaeleitoral.Service.ProcessamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/votacao")
public class ProcessamentoController {

    private final ProcessamentoService processamentoService;

    public ProcessamentoController(ProcessamentoService processamentoService) {
        this.processamentoService = processamentoService;
    }

    @GetMapping("/resultados")
    public List<CandidatosResultadoResponse> resultadosVotacao() {
        return processamentoService.buscarResultados();
    }
}
