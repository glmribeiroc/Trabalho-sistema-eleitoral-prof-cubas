package br.fibbauru.sistemaeleitoral.Controller;

import br.fibbauru.sistemaeleitoral.Entity.Eleitor;
import br.fibbauru.sistemaeleitoral.Service.EleitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eleitor")
public class EleitorController {

    private final EleitorService eleitorService;

    public EleitorController(EleitorService eleitorService) {
        this.eleitorService = eleitorService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Eleitor> cadastrarEleitor(@RequestBody Eleitor eleitor) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(eleitorService.cadastrarEleitor(eleitor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
