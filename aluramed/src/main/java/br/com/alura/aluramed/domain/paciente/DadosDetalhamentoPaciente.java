package br.com.alura.aluramed.domain.paciente;

import br.com.alura.aluramed.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(long id, String nome, String cpf, String telefone, Endereco endereco) {
    
    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }

} 
