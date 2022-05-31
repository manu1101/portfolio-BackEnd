
package com.jmc.portfolioBack.service;

import com.jmc.portfolioBack.model.Usuario;


public interface IUsuarioService {
    
    public Usuario verUsuario(Long id);
    
    public void crearUsuario(Usuario usu);
}
