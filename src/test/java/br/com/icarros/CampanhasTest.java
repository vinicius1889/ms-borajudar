package br.com.icarros;


import br.com.icarros.domain.Campanhas;
import br.com.icarros.services.JmsReceiver;
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
    public void testaInclusaoCampanha(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,1);
        Campanhas campanha = new Campanhas();
//        campanha.setDataFim(cal.getTime());
//        campanha.setDataInicio(Calendar.getInstance().getTime());
        campanha.setDescricao("descricao de teste ");
        campanha.setTitulo("titulo de teste");
        Campanhas campanhaRetorno = rest.postForObject("/campanhas",campanha, Campanhas.class);
        assertNotNull(campanhaRetorno);
    }


}
