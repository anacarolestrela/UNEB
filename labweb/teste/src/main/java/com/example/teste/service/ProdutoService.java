package com.example.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste.model.Produto;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listTodos() {
        return produtoRepository.findAll();
    }

    public Produto acheID(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }



}
