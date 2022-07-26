package com.jmc.portfolioBack.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.jmc.portfolioBack.model.Usuario;
import com.jmc.portfolioBack.repository.UsuarioRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    private UsuarioRepository usuarioRepository;
	
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        public UsuarioController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
                this.usuarioRepository = usuarioRepository;
                this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        }

        @PostMapping("/usuarios/")
        public void saveUsuario(@RequestBody Usuario user) {
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                usuarioRepository.save(user);
        }

        @GetMapping("/usuarios/")
        public List<Usuario> getAllUsuarios() {
                return usuarioRepository.findAll();
        }

        @GetMapping("/usuarios/{usuario}")
        public Usuario getUsuario(@PathVariable String usu) {
                return usuarioRepository.findByUsername(usu);
        }
}
