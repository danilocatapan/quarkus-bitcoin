package br.com.catapan.resoure;

import br.com.catapan.model.Usuario;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listar() {
        return Usuario.listAll();
    }
}
