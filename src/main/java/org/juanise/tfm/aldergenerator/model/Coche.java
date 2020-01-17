package org.juanise.tfm.aldergenerator.model;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@NamedNativeQuery(name = "Coche.buscarCercano",
            query = "select * from (\n" +
                    "SELECT id, latitud, longitud, (acos(sin(radians(:latitud)) * sin(radians(Latitud)) + \n" +
                    "cos(radians(:latitud)) * cos(radians(latitud)) * \n" +
                    "cos(radians(:longitud) - radians(longitud))) * 6378) as \n" +
                    "distancia \n" +
                    "from Coche) coches_condistancias\n" +
                    "order by distancia limit 1;"
        , resultSetMapping = "CocheMapping"
)
@SqlResultSetMapping(
        name="CocheMapping",
        classes = {
                @ConstructorResult(
                        targetClass = Coche.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Integer.class),

                                @ColumnResult(name = "LATITUD", type = Double.class),
                                @ColumnResult(name = "LONGITUD", type = Double.class),
                                @ColumnResult(name = "DISTANCIA", type = Double.class)
                        }
                )}
)
public class Coche {
    @Id
    @Column
    private Integer id;
    @Column
    private String url;
    @Embedded
    private Ubicacion ubicacion;

    public Coche(Integer id, Double latitud, Double longitud, Double distancia) {
        this(id, null, new Ubicacion(latitud, longitud, distancia));
    }

}
