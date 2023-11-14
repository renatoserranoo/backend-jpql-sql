package com.backendjpa.back.service;

import com.backendjpa.back.DTO.PedidoDto;
import com.backendjpa.back.DTO.ProdutoDto;
import com.backendjpa.back.entity.Pedido;
import com.backendjpa.back.entity.Produto;
import com.backendjpa.back.repository.PedidoRepository;
import com.backendjpa.back.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public PedidoDto insert(PedidoDto pedido) {
        Pedido ped = new Pedido(pedido.getEndereco());

        for(ProdutoDto p : pedido.getProdutos()) {
            Produto produto = produtoRepository.getReferenceById(p.getId());
            ped.getProdutos().add(produto);
        }

        ped = pedidoRepository.save(ped);
        return new PedidoDto(ped);

    }

    @Transactional(readOnly = true)
    public List<PedidoDto> findAll (){
        List<Pedido> list = pedidoRepository.findAll();
        return list.stream().map(x -> new PedidoDto(x)).collect(Collectors.toList());
    }
}
