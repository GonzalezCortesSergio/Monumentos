package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.service.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monumentos")
@RequiredArgsConstructor
public class MonumentoController {

    //Atributos
    private final MonumentoService service;


    //Métodos


    @GetMapping
    public ResponseEntity<List<Monumento>> buscarTodos() {

        List<Monumento> lista = service.findAll();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> buscarPorId(@PathVariable Long id) {

        Optional<Monumento> optionalMonumento = service.findById(id);

        return optionalMonumento.map(monumento -> new ResponseEntity<>(monumento, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Monumento> crear(@RequestBody Monumento monumento) {

        return new ResponseEntity<>(service.save(monumento), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Monumento> editar(@PathVariable Long id, @RequestBody Monumento cambio) {

        Optional<Monumento> optionalMonumento = service.findById(id);

        if(optionalMonumento.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<Monumento>(service.edit(id, cambio), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id) {

        if (service.findById(id).isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
