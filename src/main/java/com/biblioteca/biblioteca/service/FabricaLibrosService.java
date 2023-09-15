package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.dto.LibroDto;
import com.biblioteca.biblioteca.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricaLibrosService {

    public Libro crearLibro(LibroDto libroDto){
       return new Libro(libroDto);

    }
    public LibroDto crearLibroDto(Libro libro){
        return new LibroDto(libro);
    }
    public List<LibroDto> crearLibrosDto(List<Libro>listLibro){
        List<LibroDto> libroDtos = new ArrayList<>();
        listLibro.forEach(libro->libroDtos.add(new LibroDto(libro)));
        return libroDtos;
    }
}
