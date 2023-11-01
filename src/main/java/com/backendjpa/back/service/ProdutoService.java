package com.backendjpa.back.service;

import com.backendjpa.back.entity.Produto;
import com.backendjpa.back.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto create(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Optional<Produto> findById(Integer id) {
        return repository.findById(id);

    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Produto> findProdutoParam(Integer id, Double preco){
        return repository.findProdutoParam(id,preco);
    }

    public Optional<Produto> findProdutoParamSQL(Integer id, Double preco){
        return repository.findProdutoParamSQL(id,preco);
    }

    public Optional<Produto> findProdutoNome(Integer id, String nome){
        return repository.findProdutoByNome(id, nome);
    }

    public Optional<Produto> findProdutoNomeSQL(Integer id, String nome){
        return repository.findProdutoByNomeSQL(id, nome);
    }
}
