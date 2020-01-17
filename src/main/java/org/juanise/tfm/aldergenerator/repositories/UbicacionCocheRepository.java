package org.juanise.tfm.aldergenerator.repositories;

import org.juanise.tfm.aldergenerator.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionCocheRepository extends JpaRepository<Coche, Integer> {

    Coche buscarCercano(Double latitud, Double longitud);
}
