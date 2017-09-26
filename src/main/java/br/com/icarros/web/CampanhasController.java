package br.com.icarros.web;

import br.com.icarros.domain.Campanhas;
import br.com.icarros.dto.CampanhasDTO;
import br.com.icarros.services.CampanhasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/campanhas")
public class CampanhasController {

    @Autowired
    private CampanhasService service;

    @RequestMapping(value="",method = RequestMethod.GET)
    public Campanhas getCampanhas(){
        return service.getCampanhaAtiva();
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    public Campanhas salvaCampanha(@RequestBody CampanhasDTO campanha) throws IOException {
        return service.salvarCampanha(campanha);
    }

}
