package com.lista.listadef.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lista.listadef.model.Produto;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> ListarTodos(){
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }


    public void delete(Long id){
        produtoRepository.deleteById(id);
    }

    
    

    

}
