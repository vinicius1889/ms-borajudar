package br.com.icarros.services;

import br.com.icarros.adapter.CampanhaAdapter;
import br.com.icarros.domain.Campanhas;
import br.com.icarros.dto.CampanhasDTO;
import br.com.icarros.repo.CampanhasRepo;
import br.com.icarros.repo.ParceirosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;

@Service
public class CampanhasService {

    @Autowired
    private CampanhasRepo repo;

    @Autowired
    private ParceirosRepo parceirosRepo;

    @Autowired
    private CampanhaAdapter adapter;



    public Campanhas getCampanhaAtiva() {
        return repo.findCampanhaAtivdaByDate(Calendar.getInstance().getTime());
    }


    public Campanhas salvarCampanha(CampanhasDTO campanhaDTO) throws IOException {
        final Campanhas campanha = adapter.adapterCampanhasDTOCampanhas(campanhaDTO);
        Campanhas campanhaAtiva = this.getCampanhaAtiva();
        if(campanhaAtiva!=null)
            campanha.setId(campanhaAtiva.getId());

        campanhaDTO.getParceirosIds()
                        .forEach( s-> campanha.getListaParceiros()
                                                .add(this.parceirosRepo.findByCnpj(s))
                                );
        return repo.save(campanha);
    }


}
