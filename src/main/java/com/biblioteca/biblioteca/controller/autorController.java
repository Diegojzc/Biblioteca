package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.AutorDto;
import com.biblioteca.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/biblioteca/autores")
public class autorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorDto> save(@RequestBody AutorDto autorDto){
        return  new ResponseEntity<> (autorService.save(autorDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AutorDto>> findAll(){
        return new ResponseEntity<>(autorService.finAll(),HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AutorDto> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(autorService.findById(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBId(@PathVariable Integer id){
        try {
            autorService.delateById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
