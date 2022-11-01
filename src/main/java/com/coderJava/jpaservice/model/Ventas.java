package com.coderJava.jpaservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate altaProducto;
    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;


}
