package br.com.alura.aluramed.Paciente;

import br.com.alura.aluramed.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        String nome, 
        String email, 
        String telefone, 
        String cpf, 
        DadosEndereco endereco) {
}
