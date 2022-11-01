package com.coderJava.jpaservice.repository;

import com.coderJava.jpaservice.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {
}
