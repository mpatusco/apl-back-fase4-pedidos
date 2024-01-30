package com.fiap.pedidos.gateways;

import com.fiap.pedidos.interfaces.gateways.IProducaoRepositoryPort;
import com.fiap.pedidos.interfaces.repositories.ProducaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProducaoRepositoryAdapter implements IProducaoRepositoryPort {

    private final ProducaoRepository producaoRepository;

    @Override
    public void inserePedidoNaProducao(UUID idPedido, UUID idCliente) {
        this.producaoRepository.inserePedidoNaProducao(idPedido, idCliente);
    }
}
