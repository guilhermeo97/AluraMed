package br.com.alura.aluramed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.aluramed.domain.consulta.ConsultaService;
import br.com.alura.aluramed.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.aluramed.domain.consulta.DadosCancelamentoConsulta;
import br.com.alura.aluramed.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    
    @Autowired
    private ConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        service.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null,null,null,null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelalr(@RequestBody @Valid DadosCancelamentoConsulta dados){
        service.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
