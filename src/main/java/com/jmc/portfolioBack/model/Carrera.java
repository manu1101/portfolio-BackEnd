
package com.jmc.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Carrera {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    private String insti;
    private String f_inicio;
    private String f_fin;

    public Carrera(Long id, String titulo, String insti, String f_inicio, String f_fin) {
        this.id = id;
        this.titulo = titulo;
        this.insti = insti;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
    }

    public Carrera() {
    }
}
