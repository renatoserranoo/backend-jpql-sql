package com.backendjpa.back.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "tb_produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nome;
    private String produto;

    public Produto(Integer id, String nome, String produto) {
        this.id = id;
        this.nome = nome;
        this.produto = produto;
    }

    public Produto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto1 = (Produto) o;
        return Objects.equals(id, produto1.id) && Objects.equals(nome, produto1.nome) && Objects.equals(produto, produto1.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, produto);
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

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
