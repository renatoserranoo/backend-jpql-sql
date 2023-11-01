package com.backendjpa.back.controller;

import com.backendjpa.back.entity.Produto;
import com.backendjpa.back.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Produto produto) {
        Produto prod = service.create(produto);
        return prod != null ? new ResponseEntity<>("Produto criado com sucesso", HttpStatus.CREATED) : new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> list = service.findAll();
        return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/produto-jpa-id/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Integer id){
        Optional<Produto> prod = service.findById(id);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/produto-update")
    public ResponseEntity<String> update(@RequestBody Produto produto){
        Produto prod = service.create(produto);
        return prod !=  null ? new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK)
                : new ResponseEntity<>("Erro ao atualizar produto", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/produto-delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        Optional<Produto> prod = service.findById(id);
        return !prod.isPresent() ? new ResponseEntity<>("Produto deletado com sucesso", HttpStatus.OK)
                : new ResponseEntity<>("Erro ao deletar produto", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/produto-jpa-id-preco-jpql/{id}/{preco}")
    public ResponseEntity<Optional<Produto>> findByIdPrecoJpql(@PathVariable Integer id, @PathVariable Double preco){
        Optional<Produto> prod = service.findProdutoParam(id, preco);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/produto-jpa-id-preco-sql/{id}/{preco}")
    public ResponseEntity<Optional<Produto>> findByIdPrecoSql(@PathVariable Integer id, @PathVariable Double preco){
        Optional<Produto> prod = service.findProdutoParamSQL(id, preco);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/produto-jpa-id-nome-jpql/{id}/{preco}")
    public ResponseEntity<Optional<Produto>> findByIdNomeJpql(@PathVariable Integer id, @PathVariable String nome){
        Optional<Produto> prod = service.findProdutoNome(id, nome);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/produto-jpa-id-nome-sql/{id}/{preco}")
    public ResponseEntity<Optional<Produto>> findByIdNomeSql(@PathVariable Integer id, @PathVariable String nome){
        Optional<Produto> prod = service.findProdutoNomeSQL(id, nome);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }
}
