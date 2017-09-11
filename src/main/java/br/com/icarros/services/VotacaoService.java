package br.com.icarros.services;

import br.com.icarros.domain.Usuarios;
import br.com.icarros.dto.RankingDTO;
import br.com.icarros.dto.RequestVotacaoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class VotacaoService {

    @Autowired
    private RestTemplate rest;

    @Value("${borajudar.score.endpoint.root}")
    private String endpont;

    @Autowired
    private UsuarioService usuarioService;

    public Map<String,Object> votar(RequestVotacaoDTO votacao) {
        Usuarios usuarios = usuarioService.cadastraUsuario(votacao.getUsuario());
        votacao.setUsuario(usuarios);
        Map<String, Object> scoreMap = this.getScoreMap(votacao);
        return rest.postForObject(endpont + "/score/computevoto", scoreMap, Map.class);
    }

    public Map<String,Object> getRanking(String idCampanha) {
        return rest.getForObject(endpont+"/score/ranking/"+idCampanha,Map.class);
    }


    /**
     * Metodo que retorna o mapa de parametros conforme o serviço de votação precisa receber
     *
     * @param votacao
     * @return
     */
    private  Map<String,Object> getScoreMap(RequestVotacaoDTO votacao){
        Map<String,Object> mapa = new HashMap<>();
        mapa.put("keyCampanha",votacao.getKeyCampanha());
        mapa.put("keyParceiro",votacao.getKeyParceiro());
        mapa.put("keyUsuario",votacao.getUsuario().getId());
        return mapa;
    }


}
