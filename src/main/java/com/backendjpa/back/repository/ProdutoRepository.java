package com.backendjpa.back.repository;

import com.backendjpa.back.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE p.id = :id AND p.preco <= :preco")
    Optional<Produto> findProdutoParam(Integer id, Double preco);

    @Query(value = "SELECT p FROM tb_produto p WHERE p.id = :id AND p.preco <= :preco", nativeQuery = true)
    Optional<Produto> findProdutoParamSQL(Integer id, Double preco);

    @Query("SELECT p FROM Produto p WHERE p.id = :id AND p.nome = :nome")
    Optional<Produto> findProdutoByNome(Integer id,String nome);

    @Query(value = "SELECT p FROM tb_produto p WHERE p.id = :id AND p.nome = :nome", nativeQuery = true)
    Optional<Produto> findProdutoByNomeSQL(Integer id, String nome);
}
