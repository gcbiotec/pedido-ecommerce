package com.fundatec.pedido.service;

import com.fundatec.pedido.domain.Pedido;
import com.fundatec.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe que orquestra as requisições de pedido
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    /**
     * Método para encontrar todos os pedidos do repositório
     * @return
     */
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    /**
     * Método para salvar um pedido no repositório
     * @param pedido
     * @return
     */
    public Pedido save(Pedido pedido) {
        return pedidoRepository.saveAndFlush(pedido);
    }

    /**
     * Método para procurar um pedido por um identificador
     * @param id
     * @return
     */
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).get();
    }
}
