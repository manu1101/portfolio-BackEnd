
package com.jmc.portfolioBack.service;

import com.jmc.portfolioBack.model.Usuario;
import com.jmc.portfolioBack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    public UsuarioRepository usuRepo;
 
    @Override
    public Usuario verUsuario(Long id) {
        return usuRepo.findById(id).orElse(null);
    }

    @Override
    public void crearUsuario(Usuario usua) {
       usuRepo.save(usua);
    }

}