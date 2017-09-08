package br.com.icarros.services;

import br.com.icarros.domain.Parceiro;
import br.com.icarros.repo.ParceirosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParceirosService {

    @Autowired
    private ParceirosRepo repo;


    public Parceiro salvar(Parceiro parceiro) {
        Parceiro byCnpj = repo.findByCnpj(parceiro.getCnpj());
        if(byCnpj!=null){
            parceiro.setId(byCnpj.getId());
        }
        return repo.save(parceiro);
    }
}
