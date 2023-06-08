package br.com.alura.aluramed.domain.consulta;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.aluramed.domain.medico.Especialidade;
import br.com.alura.aluramed.domain.medico.Medico;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    
    
}
