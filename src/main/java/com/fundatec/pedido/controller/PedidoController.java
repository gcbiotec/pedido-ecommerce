package com.fundatec.pedido.controller;

import com.fundatec.pedido.domain.Pedido;
import com.fundatec.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> resultado = pedidoService.findAll();
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
