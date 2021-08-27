package br.com.catapan.repository;

import br.com.catapan.model.Ordem;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
class OrdemRepositoryTest {

    @InjectMock
    OrdemRepository ordemRepositoryMock;

    @Test
    void testarSeListAllRetornaOrdensCorretas() {
        Ordem primeiraOrdem = new Ordem();
        Ordem segundaOrdem = new Ordem();
        List<Ordem> ordens = new ArrayList<Ordem>();

        ordens.add(primeiraOrdem);
        ordens.add(segundaOrdem);

        Mockito.when(ordemRepositoryMock.listAll()).thenReturn(ordens);

        Assertions.assertSame(segundaOrdem, ordemRepositoryMock.listAll().get(1));
    }
}
