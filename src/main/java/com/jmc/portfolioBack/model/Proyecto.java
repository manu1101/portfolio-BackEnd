
package com.jmc.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String nombrep;
    private String descripcion;
    private String fecha;

    public Proyecto(Long id, String nombrep, String descripcion, String fecha) {
        this.id = id;
        this.nombrep = nombrep;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Proyecto() {
    }
}
