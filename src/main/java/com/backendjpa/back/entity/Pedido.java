package com.backendjpa.back.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="tb_pedido")
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String endereco;


    @ManyToMany
    @JoinTable(name="tb_pedido_produto", joinColumns = @JoinColumn(name="id_pedido"),
            inverseJoinColumns = @JoinColumn(name="id_produto"))
    private Set<Produto> produtos = new HashSet<>();

    public Pedido(){}

    public Pedido(Integer id, String endereco) {
        this.id = id;
        this.endereco = endereco;
    }

    public Pedido(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(endereco, pedido.endereco) && Objects.equals(produtos, pedido.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endereco, produtos);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
