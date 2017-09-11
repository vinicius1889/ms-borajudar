package br.com.icarros.services;

import br.com.icarros.domain.Usuarios;
import br.com.icarros.repo.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepo repo;

    public Usuarios cadastraUsuario(Usuarios usuario){
        Usuarios byCpf = repo.findByCpf(usuario.getCpf());
        if(byCpf!=null){
            usuario.setId(byCpf.getId());
        }
        return repo.save(usuario);
    }


}
