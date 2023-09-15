package com.biblioteca.biblioteca.dto;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Libro;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AutorDto {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private List<LibroDto> libroDto;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.apellidos = autor.getApellidos();
        this.telefono = autor.getTelefono();
        this.libroDto=new ArrayList<>();
        autor.getLibro().forEach(libro->libroDto.add(new LibroDto(libro)));
    }
}
