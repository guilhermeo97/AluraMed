package br.com.alura.aluramed.domain.medico;

public record DadosListagemMedico(
    long id,
    String nome,    
    String email,
    String crm, 
    Especialidade especialidade
) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());

    }

} 
