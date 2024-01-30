package com.fiap.pedidos.interfaces.gateways;

import java.util.UUID;

public interface IProducaoRepositoryPort {
    void inserePedidoNaProducao(UUID idPedido, UUID idCliente);
}
