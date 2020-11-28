package com.fundatec.pedido.service;

import com.fundatec.pedido.PedidoApplication;
import com.fundatec.pedido.domain.Pedido;
import com.fundatec.pedido.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = PedidoApplication.class)
class PedidoServiceTest {

    @Autowired
    private PedidoService pedidoService;

    @MockBean
    private PedidoRepository pedidoRepository;

    private Pedido createPedido() {
        Pedido pedido = new Pedido();
        pedido.setClienteId(1L);
        pedido.setId(2L);
        return pedido;
    }

    @Test
    void findAll_Pedido() {
        List<Pedido> pedidosEsperados = new ArrayList<>();
        pedidosEsperados.add(createPedido());

        Mockito.when(pedidoRepository.findAll()).thenReturn(pedidosEsperados);

        List<Pedido> result = pedidoService.findAll();

        assertEquals(pedidosEsperados, result);
    }

    @Test
    void findById_Pedido() {
        Pedido pedido = createPedido();

        Mockito.when(pedidoRepository.findById(2L)).thenReturn(Optional.of(pedido));

        Pedido result = pedidoService.findById(2L);

        assertEquals(pedido, result);

    }

    @Test
    void save_Pedido() {
        Pedido pedido = createPedido();

        Mockito.when(pedidoRepository.saveAndFlush(pedido)).thenReturn(pedido);

        Pedido result = pedidoService.save(pedido);

        assertEquals(pedido, result);
    }


}