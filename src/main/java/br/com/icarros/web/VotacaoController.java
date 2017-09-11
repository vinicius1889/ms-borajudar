package br.com.icarros.web;

import br.com.icarros.dto.RankingDTO;
import br.com.icarros.services.VotacaoService;
import br.com.icarros.dto.RequestVotacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by vinicius on 08/09/17.
 */
@RequestMapping("/votacao")
@RestController
public class VotacaoController {

    @Autowired
    private VotacaoService service;


    @RequestMapping(value="/",method = RequestMethod.POST)
    public Map<String,Object> votar(@RequestBody RequestVotacaoDTO votacao){
        return service.votar(votacao);
    }


    @RequestMapping(value="/{idCampanha}",method = RequestMethod.GET)
    public Map<String,Object> ranking(@PathVariable("idCampanha") String idCampanha){
        return service.getRanking(idCampanha);
    }
}
