
package com.jmc.portfolioBack.service;

import com.jmc.portfolioBack.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona verPersona(Long id);
}
