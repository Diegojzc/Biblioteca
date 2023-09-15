package com.biblioteca.biblioteca.model;

import com.biblioteca.biblioteca.dto.AutorDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libro;

    public Autor(AutorDto autorDto) {
        this.id = autorDto.getId();
        this.nombre = autorDto.getNombre();
        this.apellidos = autorDto.getApellidos();
        this.telefono = autorDto.getTelefono();
    }
}
