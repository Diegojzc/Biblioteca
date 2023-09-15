package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.dto.LibroDto;
import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.repository.AutorRepository;
import com.biblioteca.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private FabricaLibrosService fabricaLibrosService;

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private FabricaAutorService fabricaAutorService;

    public LibroDto save(LibroDto libroDto){
        Autor autor = autorRepository.findById(libroDto.getIdAutor()).get();
        libroDto.setAutorDto(fabricaAutorService.crearAutorDto(autor));
        return fabricaLibrosService.crearLibroDto(libroRepository.save(fabricaLibrosService.crearLibro(libroDto)));
    }

    public List<LibroDto> findAll(){
        return fabricaLibrosService.crearLibrosDto(libroRepository.findAll());
    }
    public LibroDto findById(Integer id){
        return fabricaLibrosService.crearLibroDto(libroRepository.findById(id).get());
    }

    public void deleteById(Integer id){
       libroRepository.deleteById(id);
    }
}
