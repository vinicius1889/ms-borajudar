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

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VotacaoTest {


    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TestRestTemplate rest;


    @Test
    public void testaVoto() throws JsonProcessingException {
        for(int  i = 0; i<10;i++){
            RequestVotacaoDTO dto = new RequestVotacaoDTO();
            dto.setKeyParceiro("59b2d3ca41c161f7b49f04bd"+i);
            dto.setKeyCampanha("59b6c47bf0c97a072457e656");
            Usuarios user = new Usuarios();
            user.setCpf("123456-"+i);
            dto.setUsuario(user);
            RankingDTO rankingDTO = rest.postForObject("/votacao/", dto, RankingDTO.class);
            mapper.writeValueAsString(rankingDTO);
        }
    }

    @Ignore
    @Test
    public void testaRanking() throws JsonProcessingException {
        RankingDTO rankingDTO = rest.getForObject("/ranking", RankingDTO.class);
        mapper.writeValueAsString(rankingDTO);
    }

}
