package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.LibroDto;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
import com.biblioteca.biblioteca.service.FabricaLibrosService;
import com.biblioteca.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/biblioteca/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseEntity<LibroDto> save(@RequestBody LibroDto libroDto) {
        try{
            return new ResponseEntity<>(libroService.save(libroDto), HttpStatus.CREATED);
        }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/todos")
    public ResponseEntity<List<LibroDto>> findAll() {
        return new ResponseEntity<>(libroService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LibroDto> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(libroService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
         public ResponseEntity<HttpStatus> delatebyId(@PathVariable Integer id){

        try{
            libroService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
          }
}
