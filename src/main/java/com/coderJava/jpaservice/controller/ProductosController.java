package com.coderJava.jpaservice.controller;


import com.coderJava.jpaservice.model.Producto;
import com.coderJava.jpaservice.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "api/product")
@RestController
public class ProductosController {

    @Autowired
    private ProductoService ps;

    @PostMapping("/")
    public ResponseEntity<Producto> create (@RequestBody Producto p){
        return new ResponseEntity<>(this.ps.create(p), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Producto>>finAll(){
        return new ResponseEntity<>(this.ps.findAll(), HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Producto> update (@RequestBody Producto pUpdate, @PathVariable("id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ps.update(pUpdate, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delet(@PathVariable("id") Long id){
        ps.delet(id);
        return ResponseEntity.ok().build();
    }



}
