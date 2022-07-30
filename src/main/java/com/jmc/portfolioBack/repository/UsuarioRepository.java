package com.jmc.portfolioBack.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmc.portfolioBack.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Usuario findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}