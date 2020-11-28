package com.fundatec.pedido.controller;

import com.fundatec.pedido.domain.Pedido;
import com.fundatec.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
        Pedido pedidoSalvo = pedidoService.save(pedido);
        return new ResponseEntity<>(pedidoSalvo, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pedido> findById(@PathVariable("id") Long id){
        Pedido pedidoReturn = pedidoService.findById(id);
        return new ResponseEntity<Pedido>(pedidoReturn, HttpStatus.OK);
    }
}
