
package com.jmc.portfolioBack.controller;

import com.jmc.portfolioBack.model.Usuario;
import com.jmc.portfolioBack.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuServ;
    
    @PostMapping("/iniciar-sesion")
    public String obtenerUsuario(@RequestBody Usuario usu){
        return usu.getUsuario();
    }
}
