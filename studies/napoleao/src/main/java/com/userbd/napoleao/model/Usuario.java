package com.userbd.napoleao.model;

import org.springframework.beans.BeanUtils;

import com.userbd.napoleao.dto.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true
)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String senha;    
    @Column(nullable = false)
    private String email;

    public Usuario(UsuarioDTO usuarioDTO){
        BeanUtils.copyProperties(usuarioDTO, this);
    }
    public Usuario(){
        
    }

}
