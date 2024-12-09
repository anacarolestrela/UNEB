package com.example.teste.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste.model.Produto;

public interface ProdutoRepository  extends JpaRepository <Produto, Long >{
        List<Produto> findByNomeContainingIgnoreCase(String nome);


        
}
