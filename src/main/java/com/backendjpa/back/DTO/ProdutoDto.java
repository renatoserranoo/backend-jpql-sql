package com.backendjpa.back.DTO;

import com.backendjpa.back.entity.Produto;

public class ProdutoDto {
    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDto(){

    }
    public ProdutoDto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public ProdutoDto(Produto produto){
        id = produto.getId();
        nome = produto.getNome();
        preco = produto.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
