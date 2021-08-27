package br.com.catapan.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
class UsuarioTest {

    @Test
    void testarSeFindByIdOptionalRetonarUsuarioCorreto() {
        PanacheMock.mock(Usuario.class);

        Usuario usuario = new Usuario();
        Optional<PanacheEntityBase> usuarioOptinal = Optional.of(usuario);

        Mockito.when(Usuario.findByIdOptional(123)).thenReturn(usuarioOptinal);

        Assertions.assertSame(usuario, Usuario.findByIdOptional(123).get());
    }
}
