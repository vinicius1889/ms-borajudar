package br.com.icarros.repo;

import br.com.icarros.domain.Campanhas;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface CampanhasRepo extends AbstractRepo<Campanhas,String> {
    @Query("{ dataInicio: { $lte: ?0 }, dataFim:{  $gte: ?0 }  }")
    Campanhas findCampanhaAtivdaByDate(Date now);
}
