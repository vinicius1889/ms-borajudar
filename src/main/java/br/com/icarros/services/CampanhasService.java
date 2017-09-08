package br.com.icarros.services;

import br.com.icarros.domain.Campanhas;
import br.com.icarros.repo.CampanhasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampanhasService {

    @Autowired
    private CampanhasRepo repo;

    public Campanhas getCampanhaAtiva() {
        return null;
    }

    public Campanhas salvarCampanha(Campanhas campanha) {
        return repo.save(campanha);
    }
}
