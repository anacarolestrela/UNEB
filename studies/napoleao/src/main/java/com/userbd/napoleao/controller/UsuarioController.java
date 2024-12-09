package com.userbd.napoleao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userbd.napoleao.dto.UsuarioDTO;
import com.userbd.napoleao.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;
    
    
    @GetMapping
    public Page<UsuarioDTO> listarTodos(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return usuarioService.listarTodosPaginado(pageable);
    }

    @PostMapping
    public void add(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.add(usuarioDTO);
    }
    

    @PutMapping
    public UsuarioDTO alterar(@RequestBody UsuarioDTO usuarioDTO) {
        
        return usuarioService.alterar(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/email")
        public ResponseEntity<Void> atualizarEmail(@PathVariable Long id, @RequestParam String email){
            usuarioService.atualizarEmail(id, email);
            return ResponseEntity.ok().build();
    }
    

}
