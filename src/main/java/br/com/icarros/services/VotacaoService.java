package br.com.icarros.services;

import br.com.icarros.dto.RankingDTO;
import br.com.icarros.dto.RequestVotacaoDTO;
import br.com.icarros.dto.ResponseVotacaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Service
public class VotacaoService {

    @Autowired private RestTemplate rest;

    public RequestVotacaoDTO votar(ResponseVotacaoVO votacao) {
        return null;
    }

    public RankingDTO getRanking() {
        return null;
    }
}
