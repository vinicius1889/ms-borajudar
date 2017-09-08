package br.com.icarros.repo;

import br.com.icarros.domain.Parceiro;
import org.springframework.stereotype.Repository;

@Repository
public interface ParceirosRepo extends AbstractRepo<Parceiro,String> {

    Parceiro findByCnpj(String cnpj);

}
