package br.com.alura.aluramed.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.aluramed.Paciente.DadosCadastroPaciente;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    
    @PostMapping
    public void cadastrarPaciente(@RequestBody DadosCadastroPaciente dados){
        System.out.println(dados);
    }
}
