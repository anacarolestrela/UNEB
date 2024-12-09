package com.userbd.napoleao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.userbd.napoleao.dto.UsuarioDTO;
import com.userbd.napoleao.model.Usuario;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO>listarTodos(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();//converte o usuario para dto
    }
    public Page<UsuarioDTO> listarTodosPaginado(Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(usuario -> new UsuarioDTO(usuario));
    }

    public void add(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(usuarioDTO);
        usuarioRepository.save(usuario);
    }

    public UsuarioDTO alterar(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(usuarioDTO);
        return new UsuarioDTO(usuarioRepository.save(usuario));//o save funciona tanto para salvar quanto para atualizar

    }

    public void excluir(Long id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public UsuarioDTO buscarId(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }

    public void atualizarEmail(Long id, String email) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
        usuario.setEmail(email);
        usuarioRepository.save(usuario);
    }

}
