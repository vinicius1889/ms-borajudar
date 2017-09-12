package br.com.icarros;


import br.com.icarros.domain.Parceiro;
import br.com.icarros.domain.Usuarios;
import br.com.icarros.dto.RankingDTO;
import br.com.icarros.dto.RequestVotacaoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VotacaoTest {


    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TestRestTemplate rest;


    @Ignore
    @Test
    public void testaVoto() throws JsonProcessingException {
        for(int  i = 0; i<10;i++){
            RequestVotacaoDTO dto = new RequestVotacaoDTO();
            dto.setKeyParceiro("59b2d3ca41c161f7b49f04bd"+i);
            dto.setKeyCampanha("59b6c47bf0c97a072457e656");
            Usuarios user = new Usuarios();
            user.setCpf("123456-"+i);
            dto.setUsuario(user);
            Map<String,Object> rankingDTO = rest.postForObject("/votacao/", dto, Map.class);
            mapper.writeValueAsString(rankingDTO);
        }
    }


    @Test
    public void testaRanking() throws JsonProcessingException {
        Map<String,Object> rankingDTO = rest.getForObject("/votacao/{idCampanha}", Map.class,"59b6f212f0c97a205e05e1b1");
        String s = mapper.writeValueAsString(rankingDTO);


    }

}
