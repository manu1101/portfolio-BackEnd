package com.jmc.portfolioBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmc.portfolioBack.model.Usuario;
import com.jmc.portfolioBack.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
  @Autowired
  UsuarioRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario user = userRepository.findByUsername(username);

    return DetallesUsuario.build(user);
  }

}