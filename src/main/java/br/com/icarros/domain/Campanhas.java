package br.com.icarros.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Document(collection = "campanhas")
public class Campanhas implements Serializable{

    @Id
    private String id;
    private String titulo;
    private String descricao;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private Date dataInicio;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private Date dataFim;

//    private Set<Parceiro> parceiros;

//
//    public Date getDataInicio() {
//        return dataInicio;
//    }
//
//    public void setDataInicio(Date dataInicio) {
//        this.dataInicio = dataInicio;
//    }
//
//    public Date getDataFim() {
//        return dataFim;
//    }
//
//    public void setDataFim(Date dataFim) {
//        this.dataFim = dataFim;
//    }

    public Campanhas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    public Set<Parceiro> getParceiros() {
//        return parceiros;
//    }
//
//    public void setParceiros(Set<Parceiro> parceiros) {
//        this.parceiros = parceiros;
//    }


}
