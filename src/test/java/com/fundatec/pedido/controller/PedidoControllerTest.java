package com.fundatec.pedido.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundatec.pedido.domain.Pedido;
import com.fundatec.pedido.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PedidoControllerTest {

    @Autowired
    private PedidoController pedidoController;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private MockMvc mockMvc;

    private Pedido createPedido() {
        Pedido pedido = new Pedido();
        pedido.setClienteId(1L);
        pedido.setId(2L);
        return pedido;
    }

    @Test
    public void postPedido() throws Exception {
        Pedido pedido = createPedido();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pedido);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.clienteId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantidade").value("0"));

    }


}