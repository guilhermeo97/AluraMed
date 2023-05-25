package br.com.alura.aluramed.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(
    
    @NotNull
    String login, 
    @NotNull
    String senha) {
}
