package com.backendjpa.back.service;

import com.backendjpa.back.DTO.ProdutoDto;
import com.backendjpa.back.entity.Produto;
import com.backendjpa.back.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public ProdutoDto create(ProdutoDto produto){
        Produto prod = new Produto(produto.getId(), produto.getNome(), produto.getPreco());
        return new ProdutoDto(repository.save(prod));
    }

    public List<ProdutoDto> findAll(){
        List<Produto> list = repository.findAll();
        return list.stream().map(x -> new ProdutoDto(x)).collect(Collectors.toList());

    }

    public Optional<ProdutoDto> findById(Integer id) {
        Optional<Produto> prod = repository.findById(id);
        Optional<ProdutoDto> prodDto = prod.map(produto -> {
            return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
        });
        return prodDto;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<ProdutoDto> findProdutoParam(Integer id, Double preco){
        Optional<Produto> produtoEncontrado = repository.findProdutoParam(id, preco);
        Optional<ProdutoDto> produtoDtoEncontrado = produtoEncontrado.map(produto -> {
            return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
        });
        return produtoDtoEncontrado;
    }

    public Optional<ProdutoDto> findProdutoParamSQL(Integer id, Double preco){
        Optional<Produto> produtoEncontradoSQL = repository.findProdutoParamSQL(id, preco);
        Optional<ProdutoDto> produtoDtoEncontradoSQL = produtoEncontradoSQL.map(produto -> {
            return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
        });
        return produtoDtoEncontradoSQL;
    }

    public Optional<ProdutoDto> findProdutoNome(Integer id, String nome){
        Optional<Produto> produtoEncontradoNome = repository.findProdutoByNome(id, nome);
        Optional<ProdutoDto> produtoDtoEncontradoNome = produtoEncontradoNome.map(produto -> {
            return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
        });
        return produtoDtoEncontradoNome;
    }

    public Optional<ProdutoDto> findProdutoNomeSQL(Integer id, String nome){
        Optional<Produto> produtoEncontradoNomeSQL = repository.findProdutoByNomeSQL(id, nome);
        Optional<ProdutoDto> produtoDtoEncontrado = produtoEncontradoNomeSQL.map(produto -> {
            return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
        });
        return produtoDtoEncontrado;
    }
}
