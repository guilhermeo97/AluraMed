package br.com.alura.aluramed.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.aluramed.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.aluramed.domain.consulta.ValidacaoException;
import br.com.alura.aluramed.domain.medico.MedicoRepository;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{
    
    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        if(dados.idMedico() == null){
            return;
        }

        var medicoAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com médico inativo");
        }

    }
}
