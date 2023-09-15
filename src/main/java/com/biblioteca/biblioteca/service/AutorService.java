package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.dto.AutorDto;
import com.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    public FabricaAutorService fabricaAutorService;

    @Autowired
    public AutorRepository autorRepository;

    public AutorDto save(AutorDto autorDto) {
        return fabricaAutorService.crearAutorDto(autorRepository.save(fabricaAutorService.crearAutor(autorDto)));

    }

    public List<AutorDto> finAll(){
        return fabricaAutorService.crearAutoresDto(autorRepository.findAll());
    }

    public AutorDto findById(Integer id){
        return fabricaAutorService.crearAutorDto(autorRepository.findById(id).get());

    }

    public void delateById(Integer id){
        autorRepository.deleteById(id);
    }
}
