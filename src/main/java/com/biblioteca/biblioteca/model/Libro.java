package com.biblioteca.biblioteca.model;
import com.biblioteca.biblioteca.dto.LibroDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String isbn;
    private String nombre;
    private String editorial;
    private String genero;
    private int numeroPaginas;
    private BigDecimal precio;
    private LocalDate fechaEdicion;

    @ManyToOne
    private Autor autor;

    public Libro(LibroDto libroDto) {
        this.id = libroDto.getId();
        this.isbn = libroDto.getIsbn();
        this.nombre = libroDto.getNombre();
        this.editorial = libroDto.getEditorial();
        this.genero = libroDto.getGenero();
        this.numeroPaginas = libroDto.getNumeroPaginas();
        this.precio = libroDto.getPrecio();
        this.fechaEdicion = libroDto.getFechaEdicion();
        this.autor = new Autor(libroDto.getAutorDto());
    }
}
