package br.com.alura.aluramed.domain.medico;

import br.com.alura.aluramed.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
    
    @NotBlank(message = "Nome é obrigatório")
    String nome, 
    
    @NotBlank
    @Email(message = "Email é obrigatório")
    String email, 
    
    @NotBlank(message = "Telefone é obrigatório")
    String telefone,

    @NotBlank(message = "CRM é obrigatório")
    @Pattern(regexp = "\\d{4,6}")
    String crm, 
    
    @NotNull(message = "Especialidade é obrigatória")
    Especialidade especialidade, 
    
    @NotNull(message = "Dados do endereço são obrigatórios")
    @Valid
    DadosEndereco endereco) {
}
