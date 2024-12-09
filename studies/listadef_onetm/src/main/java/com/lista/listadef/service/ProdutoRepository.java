package com.lista.listadef.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lista.listadef.model.Produto;

public interface ProdutoRepository  extends JpaRepository <Produto, Long >{
    List<Produto> findByNomeContainingIgnoreCase(String nome);


    
}