package br.com.alura.aluramed.domain.paciente;

public record DadosListagemPaciente(long id, String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
