package br.com.icarros.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by vinicius on 08/09/17.
 */
public class RankingDTO implements Serializable{
    List<Map<String,Object>> parceiros =  new LinkedList<>();
    private long pontos;

}

