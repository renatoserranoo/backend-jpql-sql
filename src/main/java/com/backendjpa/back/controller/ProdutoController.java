package com.backendjpa.back.controller;

import com.backendjpa.back.DTO.ProdutoDto;
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
    public ResponseEntity<String> insert(@RequestBody ProdutoDto produto) {
        ProdutoDto prod = service.create(produto);
        return prod != null ? new ResponseEntity<>("Produto criado com sucesso", HttpStatus.CREATED) : new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> getAll(){
        List<ProdutoDto> list = service.findAll();
        return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/produto-jpa-id/{id}")
    public ResponseEntity<Optional<ProdutoDto>> findById(@PathVariable Integer id){
        Optional<ProdutoDto> prod = service.findById(id);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/produto-update")
    public ResponseEntity<String> update(@RequestBody ProdutoDto produto){
        ProdutoDto prod = service.create(produto);
        return prod !=  null ? new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK)
                : new ResponseEntity<>("Erro ao atualizar produto", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/produto-delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        Optional<ProdutoDto> prod = service.findById(id);
        return !prod.isPresent() ? new ResponseEntity<>("Produto deletado com sucesso", HttpStatus.OK)
                : new ResponseEntity<>("Erro ao deletar produto", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/produto-jpa-id-preco-jpql/{id}/{preco}")
    public ResponseEntity<Optional<ProdutoDto>> findByIdPrecoJpql(@PathVariable Integer id, @PathVariable Double preco){
        Optional<ProdutoDto> prod = service.findProdutoParam(id, preco);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/produto-jpa-id-preco-sql/{id}/{preco}")
    public ResponseEntity<Optional<ProdutoDto>> findByIdPrecoSql(@PathVariable Integer id, @PathVariable Double preco){
        Optional<ProdutoDto> prod = service.findProdutoParamSQL(id, preco);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/produto-jpa-id-nome-jpql/{id}/{preco}")
    public ResponseEntity<Optional<ProdutoDto>> findByIdNomeJpql(@PathVariable Integer id, @PathVariable String nome){
        Optional<ProdutoDto> prod = service.findProdutoNome(id, nome);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/produto-jpa-id-nome-sql/{id}/{preco}")
    public ResponseEntity<Optional<ProdutoDto>> findByIdNomeSql(@PathVariable Integer id, @PathVariable String nome){
        Optional<ProdutoDto> prod = service.findProdutoNomeSQL(id, nome);
        return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }
}
