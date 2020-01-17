package org.juanise.tfm.aldergenerator.services;

import org.juanise.tfm.aldergenerator.model.Coche;
import org.juanise.tfm.aldergenerator.repositories.UbicacionCocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class UbicacionService {
    @Autowired
    private UbicacionCocheRepository ubicacionCocheRepository;
    @Autowired
    ResourceLoader resourceLoader;

    public Coche getCercano(Double latitud, Double longitud) {
        return ubicacionCocheRepository.buscarCercano(latitud, longitud);
    }
}
