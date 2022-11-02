package com.coderJava.jpaservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "producto")
public class producto {
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
    private com.coderJava.jpaservice.model.cliente cliente;
    @OneToMany(mappedBy = "producto")
    private List<com.coderJava.jpaservice.model.ventas> ventas;


}
