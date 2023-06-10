package br.com.alura.aluramed.domain.consulta.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import br.com.alura.aluramed.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.aluramed.domain.consulta.ValidacaoException;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{
    
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaConsulta = dataConsulta.getHour() > 18;
    
    if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaConsulta){
        throw new ValidacaoException("Consulta fora do horário de atendimento da clínica");
    }
    
    }
}
