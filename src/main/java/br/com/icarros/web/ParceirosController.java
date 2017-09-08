package br.com.icarros.web;

import br.com.icarros.domain.Parceiro;
import br.com.icarros.services.ParceirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/parceiros")
public class ParceirosController {

    @Autowired
    private ParceirosService parceiroService;


    @RequestMapping(value = "",method = RequestMethod.POST)
    public Parceiro salvaParceiro(@RequestBody Parceiro parceiro){
        return parceiroService.salvar(parceiro);
    }



}
