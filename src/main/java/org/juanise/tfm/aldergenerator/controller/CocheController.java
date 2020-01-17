package org.juanise.tfm.aldergenerator.controller;

import org.juanise.tfm.aldergenerator.model.Coche;
import org.juanise.tfm.aldergenerator.model.Ubicacion;
import org.juanise.tfm.aldergenerator.services.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/consulta")
public class CocheController {
    @Autowired
    private UbicacionService ubicacionService;
    @GetMapping(name = "cercano")
    public Resource<Coche> getCercano(@RequestBody @Valid Ubicacion ubicacion) {
        return new Resource(ubicacionService.getCercano(ubicacion.getLat(), ubicacion.getLon()));
    }
}