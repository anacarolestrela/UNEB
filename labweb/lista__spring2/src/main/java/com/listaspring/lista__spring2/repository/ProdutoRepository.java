package com.listaspring.lista__spring2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.listaspring.lista__spring2.model.Produto;

public interface ProdutoRepository  extends JpaRepository{
        List<Produto> findByNomeContainingIgnoreCase(String nome);
}
