package com.listaspring.lista__spring2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.listaspring.lista__spring2.model.Produto;
import com.listaspring.lista__spring2.service.ProdutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    
//pra listar todos os produtos
    @GetMapping
    public ResponseEntity <List<Produto>>listartodos() {
        List<Produto> produtos = produtoService.listAll();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> saveProduct (@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.saveProduct(produto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.listarPorId(id); // Assumindo que listarPorId retorna Optional<Produto>
        
        if (produto.isPresent()) {
            produtoService.deletar(id); // Deleta o produto
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se não encontrar o produto
    }
    
    

}
