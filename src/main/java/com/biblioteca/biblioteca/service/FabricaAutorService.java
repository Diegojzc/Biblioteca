package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.dto.AutorDto;
import com.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricaAutorService {

    public Autor crearAutor(AutorDto autorDto){
        return new Autor(autorDto);
    }

    public AutorDto crearAutorDto(Autor autor){
        return new AutorDto(autor);
    }

    public List<AutorDto>crearAutoresDto(List<Autor> listAutor){
        List<AutorDto> autorDtos = new ArrayList<>();

        listAutor.forEach(n->autorDtos.add(crearAutorDto(n)));
        return autorDtos;
    }
}
