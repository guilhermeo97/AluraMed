package br.com.alura.aluramed.Paciente;

import br.com.alura.aluramed.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
    @NotNull
    long id, 
    String nome, 
    String telefone, 
    DadosEndereco endereco
) {
} 
