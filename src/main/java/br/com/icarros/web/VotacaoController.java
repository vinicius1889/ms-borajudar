package br.com.icarros.web;

import br.com.icarros.dto.RankingDTO;
import br.com.icarros.dto.ResponseVotacaoVO;
import br.com.icarros.services.VotacaoService;
import br.com.icarros.dto.RequestVotacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vinicius on 08/09/17.
 */
@RequestMapping("/votacao")
@RestController
public class VotacaoController {

    @Autowired
    private VotacaoService service;


    @RequestMapping(value="/",method = RequestMethod.POST)
    public RequestVotacaoDTO votar(@RequestBody ResponseVotacaoVO votacao){
        return service.votar(votacao);
    }


    public RankingDTO ranking(){
        return service.getRanking();
    }
}
