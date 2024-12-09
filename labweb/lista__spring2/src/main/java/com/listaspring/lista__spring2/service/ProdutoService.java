package com.listaspring.lista__spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listaspring.lista__spring2.repository.ProdutoRepository;

import com.listaspring.lista__spring2.model.Produto;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listAll() {
        return produtoRepository.findAll();

    }

    public Produto listarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado com id: " + id));
    }

    public Produto saveProduct(Produto produto) {
        return (Produto) produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto com ID " + id + " não encontrado.");
        }
    }

}
