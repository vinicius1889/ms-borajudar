package br.com.icarros.repo;

import br.com.icarros.domain.Usuarios;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepo extends AbstractRepo<Usuarios,String> {
    Usuarios findByCpf(String cpf);

}
