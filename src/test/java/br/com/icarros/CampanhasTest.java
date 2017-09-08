package br.com.icarros;


import br.com.icarros.domain.Campanhas;
import br.com.icarros.dto.CampanhasDTO;
import br.com.icarros.services.JmsReceiver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CampanhasTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TestRestTemplate rest;


    @Test
    public void testaInclusaoCampanha() throws JsonProcessingException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,1);
        CampanhasDTO campanha = new CampanhasDTO();
        campanha.setDescricao("descricao de teste ");
        campanha.setTitulo("titulo de teste");
        campanha.setDataInicio(Calendar.getInstance().getTime());
        campanha.setDataFim(cal.getTime());
        campanha.getParceirosIds().add("123456");
        Campanhas campanhaRetorno = rest.postForObject("/campanhas",campanha, Campanhas.class);
        System.out.println("mapper = " + mapper.writeValueAsString(campanhaRetorno));
        assertNotNull(campanhaRetorno);
    }

    @Test
    public void testaRetornoCampanha() throws JsonProcessingException {
        Campanhas campanhaRetorno = rest.getForObject("/campanhas", Campanhas.class);
        System.out.println("mapper = " + mapper.writeValueAsString(campanhaRetorno));
        assertNotNull(campanhaRetorno);
    }


}
