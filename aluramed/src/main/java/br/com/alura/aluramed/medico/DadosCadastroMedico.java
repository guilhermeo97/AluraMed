package br.com.alura.aluramed.medico;

import br.com.alura.aluramed.endereco.DadosEndereco;

public record DadosCadastroMedico(
    String nome, 
    String email, 
    String crm, 
    Especialidade especialidade, 
    DadosEndereco endereco) {
}
