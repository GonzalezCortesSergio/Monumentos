package com.salesianostriana.dam.monumentos.service;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    //Atributos
    private final MonumentoRepository repository;


    //Métodos

    public List<Monumento> findAll() {

        return repository.findAll();
    }


    public Optional<Monumento> findById(Long id) {

        return repository.findById(id);
    }

    public Monumento save(Monumento monumento) {

        return repository.save(monumento);
    }

    public Monumento edit(Long id, Monumento cambio) {

        Monumento antiguo = repository.findById(id).orElse(null);

        if(antiguo != null){

            antiguo.setLatitud(cambio.getLatitud());
            antiguo.setDescripcion(cambio.getDescripcion());
            antiguo.setCodigoPais(cambio.getCodigoPais());
            antiguo.setLongitud(cambio.getLatitud());
            antiguo.setNombreMonumento(cambio.getNombreMonumento());
            antiguo.setNombreCiudad(cambio.getNombreCiudad());
            antiguo.setNombrePais(cambio.getNombrePais());
            antiguo.setPhotoUrl(cambio.getPhotoUrl());

            return repository.save(antiguo);

        }
        return null;
    }

    public void deleteById(Long id) {

        repository.deleteById(id);
    }
}
