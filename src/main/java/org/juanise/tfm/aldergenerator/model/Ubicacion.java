package org.juanise.tfm.aldergenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@AllArgsConstructor @NoArgsConstructor
@Data
@Embeddable
public class Ubicacion {
    @Column(name = "latitud")
    private Double lat;
    @Column(name = "longitud")
    private Double lon;
    @Transient
    private Double distancia;

}
