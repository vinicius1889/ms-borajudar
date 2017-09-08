package br.com.icarros.adapter;

import br.com.icarros.domain.Campanhas;
import br.com.icarros.dto.CampanhasDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CampanhaAdapter {

    @Autowired
    private ObjectMapper mapper;

    public Campanhas adapterCampanhasDTOCampanhas(CampanhasDTO dto) throws IOException {
        String string = mapper.writeValueAsString(dto);
        return mapper.readValue(string,Campanhas.class);
    }

}
