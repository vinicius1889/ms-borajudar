package br.com.icarros.dto;

import br.com.icarros.domain.Usuarios;

import java.io.Serializable;

/**
 * Created by vinicius on 08/09/17.
 */
public class RequestVotacaoDTO implements Serializable{

    private String keyCampanha,keyParceiro;
    private br.com.icarros.domain.Usuarios usuario;

    public String getKeyCampanha() {
        return keyCampanha;
    }

    public void setKeyCampanha(String keyCampanha) {
        this.keyCampanha = keyCampanha;
    }

    public String getKeyParceiro() {
        return keyParceiro;
    }

    public void setKeyParceiro(String keyParceiro) {
        this.keyParceiro = keyParceiro;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
