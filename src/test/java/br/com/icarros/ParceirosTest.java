package br.com.icarros;


import br.com.icarros.domain.Parceiro;
import br.com.icarros.services.JmsReceiver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParceirosTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TestRestTemplate rest;


    @Test
    public void testaInclusaoParceiro(){
        Parceiro parceiro = new Parceiro();
//        parceiro.setAvatar();
        parceiro.setDescricao("casa de teste");
        parceiro.setNome("casa 1 editado");
        parceiro.setCnpj("123456");
        Parceiro parceiro1 = rest.postForObject("/parceiros", parceiro, Parceiro.class);
        assertNotNull(parceiro1);

    }
}
