package com.fiap.pedidos.gateways;

import com.fiap.pedidos.interfaces.gateways.IProducaoRepositoryPort;
import com.fiap.pedidos.interfaces.repositories.ProducaoRepository;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProducaoRepositoryAdapterTest {

    private IProducaoRepositoryPort producaoRepositoryPortAdapter;

    @Mock
    private ProducaoRepository producaoRepository;

    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        producaoRepositoryPortAdapter = new ProducaoRepositoryAdapter(producaoRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested class InserirPedidoNaProducao {

        @Test
        @Severity(SeverityLevel.BLOCKER)
        @Description("Inserir pedido na producao")
        void deveInserirPedidoNaProducao() {
            doNothing().when(producaoRepository).inserePedidoNaProducao(any(UUID.class), any(UUID.class));
            producaoRepositoryPortAdapter.inserePedidoNaProducao(UUID.randomUUID(), UUID.randomUUID());
            verify(producaoRepository, times(1))
                    .inserePedidoNaProducao(any(UUID.class), any(UUID.class));
        }
    }
}
