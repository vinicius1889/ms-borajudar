package br.com.icarros.domain;

/**
 * Created by vinicius on 11/09/17.
 */
public class ParceiroScore extends Parceiro {
    private long count;

    public ParceiroScore() {
        super();
    }

    public ParceiroScore(String id, String nome, String descricao, String avatar, String cnpj, long count) {
        super(id, nome, descricao, avatar, cnpj);
        this.count = count;
    }

    public ParceiroScore(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


}
