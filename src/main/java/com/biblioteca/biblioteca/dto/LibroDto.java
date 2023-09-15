package com.biblioteca.biblioteca.dto;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Libro;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class LibroDto {

    private Integer id;
    private String isbn;
    private String nombre;
    private String editorial;
    private String genero;
    private int numeroPaginas;
    private BigDecimal precio;
    private LocalDate fechaEdicion;
    private AutorDto autorDto;
    private Integer idAutor;

    public LibroDto(Libro libro) {
        this.id = libro.getId();
        this.isbn = libro.getIsbn();
        this.nombre = libro.getNombre();
        this.editorial = libro.getEditorial();
        this.genero = libro.getGenero();
        this.numeroPaginas = libro.getNumeroPaginas();
        this.precio = libro.getPrecio();
        this.fechaEdicion = libro.getFechaEdicion();
       // this.autorDto = new AutorDto(libro.getAutor());
    }
}
