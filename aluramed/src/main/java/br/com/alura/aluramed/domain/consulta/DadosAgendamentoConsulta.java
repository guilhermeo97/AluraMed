package br.com.alura.aluramed.domain.consulta;

import java.time.LocalDateTime;

import br.com.alura.aluramed.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DadosAgendamentoConsulta(
    Long idMedico,

    @NotNull
    Long idPaciente,

    @NotNull
    @Future
    LocalDateTime data,

    Especialidade especialidade
) {
    
}
