package com.coderJava.jpaservice.repository;

import com.coderJava.jpaservice.model.producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepository extends JpaRepository<producto, Long> {
}
