package br.com.catapan.service;

import br.com.catapan.model.Ordem;
import br.com.catapan.model.Usuario;
import br.com.catapan.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {

        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());

        Usuario usuario = usuarioOptional.orElseThrow();

        if (usuario.getNomeUsuario().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("O usuário logado é diferente do userId");
        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }
}
