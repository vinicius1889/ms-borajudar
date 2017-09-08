package br.com.icarros.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "campanhas")
public class Campanhas implements Serializable{

    @Id
    private String id;
    private String titulo;
    private String descricao;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dataInicio;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dataFim;
    private List<Parceiro> lista = new ArrayList<Parceiro>();

    public Campanhas() { }

    public List<Parceiro> getLista() {
        return lista;
    }

    public void setLista(List<Parceiro> lista) {
        this.lista = lista;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
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
}
