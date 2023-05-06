package br.com.alura.aluramed.domain.paciente;

import br.com.alura.aluramed.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
    @NotNull
    long id, 
    String nome, 
    String telefone, 
    DadosEndereco endereco
) {
} 
