package com.lista.listadef.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lista.listadef.model.Categoria;
import com.lista.listadef.service.CategoriaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listAll() {
        return categoriaRepository.findAll();
    }

    @PatchMapping("/{id}/update")
     public ResponseEntity<Categoria> atualizar(
        @PathVariable Long id,
        @RequestBody Map<String, String> request) {

        String novoNome = request.get("novoNome");

        if (novoNome == null || novoNome.trim().isEmpty()) {
            return ResponseEntity.badRequest().build(); 
        }
    
        Categoria categoria = categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
    
        categoria.setNome(novoNome); // Atualiza o nome da categoria
        Categoria categoriaAtualizada = categoriaRepository.save(categoria); // Salva no banco
    
        return ResponseEntity.ok(categoriaAtualizada); // Retorna a categoria atualizada
    }
}
