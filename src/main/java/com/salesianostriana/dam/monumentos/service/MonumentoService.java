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

    public Monumento edit(Monumento monumento) {

        return repository.save(monumento);
    }

    public void deleteById(Long id) {

        repository.deleteById(id);
    }
}
