
package com.jmc.portfolioBack.repository;

import com.jmc.portfolioBack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByUsername(String usu);
}
