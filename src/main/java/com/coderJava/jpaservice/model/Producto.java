package com.coderJava.jpaservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String descripcion;
    @Column
    private Double precioCompra;
    @Column
    private Double precioVenta;
    @Column
    private int stock;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "producto")
    private List<Ventas> ventas;


}
