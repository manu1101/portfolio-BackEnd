
package com.jmc.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String resumen;
    private String completo;
 
    public Persona(){
        
    }

    public Persona(Long id, String nombre, String apellido, String telefono, String resumen, String completo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.resumen = resumen;
        this.completo = completo;
    }
    
    
}
