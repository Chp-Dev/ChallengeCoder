package com.coderJava.jpaservice.repository;

import com.coderJava.jpaservice.model.ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ventasRepository extends JpaRepository<ventas, Long> {
}
