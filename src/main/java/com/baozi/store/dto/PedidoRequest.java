package com.baozi.store.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Corpo JSON recebido em POST/PUT /pedidos.
 * O cliente e o produto são informados apenas pelo ID.
 */
public record PedidoRequest(
        @NotNull(message = "clienteId é obrigatório") Long clienteId,
        @NotNull(message = "produtoId é obrigatório") Long produtoId,
        @NotNull(message = "quantidade é obrigatória")
        @Min(value = 1, message = "A quantidade deve ser no mínimo 1") Integer quantidade
) {
}
