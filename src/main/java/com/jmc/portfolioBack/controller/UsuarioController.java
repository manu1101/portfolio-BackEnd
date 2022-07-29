package com.jmc.portfolioBack.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.jmc.portfolioBack.model.Usuario;
import com.jmc.portfolioBack.repository.UsuarioRepository;
import java.util.List;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    private static final Logger logger = Logger.getLogger(UsuarioController.class);
    private final AuthService authService;
    private final JwtTokenProvider tokenProvider;
    
    
    private UsuarioRepository usuarioRepository;
	
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        public UsuarioController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
                this.usuarioRepository = usuarioRepository;
                this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        }

        @PostMapping("/iniciar-sesion")
        public ResponseEntity autenticaUsuario(@Valid @RequestBody LoginRequest loginRequest){
            Authentication autentication = authService.
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

        @GetMapping("/usuarios/{username}")
        public Usuario getUsuario(@PathVariable String usu) {
                return usuarioRepository.findByUsername(usu);
        }
}
