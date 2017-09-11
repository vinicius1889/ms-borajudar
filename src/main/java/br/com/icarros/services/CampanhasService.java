package br.com.icarros.services;

import br.com.icarros.adapter.CampanhaAdapter;
import br.com.icarros.domain.Campanhas;
import br.com.icarros.domain.Parceiro;
import br.com.icarros.domain.ParceiroScore;
import br.com.icarros.dto.CampanhasDTO;
import br.com.icarros.repo.CampanhasRepo;
import br.com.icarros.repo.ParceirosRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private ObjectMapper mapper;




    public Campanhas getCampanhaAtiva() {
        return repo.findCampanhaAtivdaByDate(Calendar.getInstance().getTime());
    }


    public Campanhas salvarCampanha(CampanhasDTO campanhaDTO) throws IOException {
        final Campanhas campanha = adapter.adapterCampanhasDTOCampanhas(campanhaDTO);
        Campanhas campanhaAtiva = this.getCampanhaAtiva();
        if(campanhaAtiva!=null)
            campanha.setId(campanhaAtiva.getId());

        campanhaDTO.getParceirosIds()
                        .forEach(s -> {
                                    try {
                                        campanha.getListaParceiros()
                                                .add(this.adapterParceiroSource(this.parceirosRepo.findByCnpj(s)));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                );
        return repo.save(campanha);
    }

    private ParceiroScore adapterParceiroSource(Parceiro parceiro) throws IOException {
        String s = this.mapper.writeValueAsString(parceiro);
        ParceiroScore parceiroScore = mapper.readValue(s, ParceiroScore.class);
        parceiroScore.setCount(0L);
        return parceiroScore;
    }


}
