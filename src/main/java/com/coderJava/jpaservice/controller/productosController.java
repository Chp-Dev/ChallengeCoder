package com.coderJava.jpaservice.controller;


import com.coderJava.jpaservice.model.producto;
import com.coderJava.jpaservice.service.productoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "api/product")
@RestController
public class productosController {

    @Autowired
    private productoService ps;

    @PostMapping("/")
    public ResponseEntity<producto> create (@RequestBody producto p){
        return new ResponseEntity<>(this.ps.create(p), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<producto>>finAll(){
        return new ResponseEntity<>(this.ps.findAll(), HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<producto> update (@RequestBody producto pUpdate, @PathVariable("id") Long id) throws resourceNotFoundException {
        return new ResponseEntity<>(this.ps.update(pUpdate, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delet(@PathVariable("id") Long id){
        ps.delet(id);
        return ResponseEntity.ok().build();
    }



}
