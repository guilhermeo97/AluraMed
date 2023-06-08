package br.com.alura.aluramed.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
    @NotNull
    Long id,

    @NotNull
    MotivoCancelamento motivo
) {
}
