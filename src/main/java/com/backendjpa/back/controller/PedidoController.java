package com.backendjpa.back.controller;

import com.backendjpa.back.DTO.PedidoDto;
import com.backendjpa.back.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody PedidoDto pedido){
        PedidoDto prod = service.insert(pedido);
        return prod !=  null ? new ResponseEntity<>("Pedido criado com sucesso", HttpStatus.CREATED) :
                new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> findAll(){
        List<PedidoDto> list = service.findAll();
        return !list.isEmpty() ?  new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
}
