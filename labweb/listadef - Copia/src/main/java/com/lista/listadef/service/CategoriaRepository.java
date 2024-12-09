package com.lista.listadef.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lista.listadef.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    // Método personalizado para encontrar categorias pelo nome (opcional)
    List<Categoria> findByNomeContainingIgnoreCase(String nome);
}