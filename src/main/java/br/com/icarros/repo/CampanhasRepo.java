package br.com.icarros.repo;

import br.com.icarros.domain.Campanhas;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface CampanhasRepo extends AbstractRepo<Campanhas,String> {
//    Campanhas findByDataInicioBeforeAndDataFimAfter(LocalDate dataInicio, LocalDate dataFim);
}
