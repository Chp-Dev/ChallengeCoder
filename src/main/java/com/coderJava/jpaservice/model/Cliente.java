package com.coderJava.jpaservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String dni;
    @Column
    private LocalDate fechaNacimiento;


    @OneToMany(mappedBy = "cliente")
    private List<Producto> productos;


}
