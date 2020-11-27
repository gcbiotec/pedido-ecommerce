package com.fundatec.pedido.service;

import com.fundatec.pedido.domain.Pedido;
import com.fundatec.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.saveAndFlush(pedido);
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).get();
    }
}
