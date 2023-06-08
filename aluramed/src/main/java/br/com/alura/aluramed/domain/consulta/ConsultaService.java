package br.com.alura.aluramed.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.aluramed.domain.medico.Medico;
import br.com.alura.aluramed.domain.medico.MedicoRepository;
import br.com.alura.aluramed.domain.paciente.PacienteRepository;
import jakarta.validation.Valid;

@Service
public class ConsultaService {
    
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados){
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente informado não existe");
        }
        
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do medico informado não existe");
        }

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Escolha uma especialidade");
        }
        
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());

    }

    public void cancelar(@Valid DadosCancelamentoConsulta dados) {
        if(!consultaRepository.existsById(dados.id())){
            throw new ValidacaoException("Essa consulta não existe");
        }

        var consulta = consultaRepository.getReferenceById(dados.id());
        consulta.cancelar(dados.motivo());
    }

}
