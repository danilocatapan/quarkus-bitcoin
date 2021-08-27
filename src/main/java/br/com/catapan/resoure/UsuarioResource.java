package br.com.catapan.resoure;

import br.com.catapan.model.Usuario;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {

    @POST
    @PermitAll //permite qualquer usuario acessar
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        Usuario.adicionar(usuario);
        Usuario.persist(usuario);
    }
}
