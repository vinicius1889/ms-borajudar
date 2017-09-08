package br.com.icarros.services;

import br.com.icarros.dto.RankingDTO;
import br.com.icarros.dto.RequestVotacaoDTO;
import br.com.icarros.dto.ResponseVotacaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Service
public class VotacaoService {

    @Autowired private RestTemplate rest;

    @Value("${borajudar.score.endpoint.root}")
    private String endpont;



    public RankingDTO votar(RequestVotacaoDTO votacao) {
        return rest.postForObject(endpont + "/score", votacao, RankingDTO.class);
    }

    public RankingDTO getRanking() {
        return rest.getForObject(endpont+"/ranking",RankingDTO.class);
    }
}
