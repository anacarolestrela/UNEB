package com.userbd.napoleao.dto;

import org.springframework.beans.BeanUtils;

import com.userbd.napoleao.model.Usuario;

import lombok.Data;

@Data
public class UsuarioDTO {
    
    private Long id;
    private String nome;
    private String login;
    private String senha;    
    private String email;

    public UsuarioDTO(Usuario usuario){
        BeanUtils.copyProperties(usuario, this);
    }
    public UsuarioDTO(){
        
    }

}
