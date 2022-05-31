
package com.jmc.portfolioBack.repository;

import com.jmc.portfolioBack.model.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("persona")
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
