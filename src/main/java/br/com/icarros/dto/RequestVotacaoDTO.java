package br.com.icarros.dto;

import java.io.Serializable;

/**
 * Created by vinicius on 08/09/17.
 */
public class RequestVotacaoDTO implements Serializable{

    private String usuariokey;
    private String campanhaKey;

    public RequestVotacaoDTO() {
    }

    public String getUsuariokey() {
        return usuariokey;
    }

    public void setUsuariokey(String usuariokey) {
        this.usuariokey = usuariokey;
    }

    public String getCampanhaKey() {
        return campanhaKey;
    }

    public void setCampanhaKey(String campanhaKey) {
        this.campanhaKey = campanhaKey;
    }
}
