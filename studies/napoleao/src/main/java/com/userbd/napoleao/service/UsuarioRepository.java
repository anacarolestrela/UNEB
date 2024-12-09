package com.userbd.napoleao.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userbd.napoleao.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    


}
