package br.com.alura.aluramed.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.aluramed.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.aluramed.domain.consulta.ValidacaoException;
import br.com.alura.aluramed.domain.paciente.PacienteRepository;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{
    
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
        
}
