
package com.jmc.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Trabajo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String puesto;
    private String empresa;
    private String f_inicio;
    private String f_fin;
    private String descripcion;

    public Trabajo(Long id, String puesto, String empresa, String f_inicio, String f_fin, String descripcion) {
        this.id = id;
        this.puesto = puesto;
        this.empresa = empresa;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
        this.descripcion = descripcion;
    }

    public Trabajo() {
    }

}
