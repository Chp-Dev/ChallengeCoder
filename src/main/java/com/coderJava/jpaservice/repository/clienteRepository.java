package com.coderJava.jpaservice.repository;

import com.coderJava.jpaservice.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends JpaRepository<cliente, Long> {
}
