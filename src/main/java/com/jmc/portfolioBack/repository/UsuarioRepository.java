
package com.jmc.portfolioBack.repository;

import com.jmc.portfolioBack.model.Usuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("usuario")
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
