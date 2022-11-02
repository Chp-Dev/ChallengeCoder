package com.coderJava.jpaservice.controller;


import com.coderJava.jpaservice.model.cliente;
import com.coderJava.jpaservice.service.clienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping(path = "api/client")
@RestController
public class clienteController {

    @Autowired
    private clienteService cs;

    @PostMapping("/")
    public ResponseEntity<cliente> create (@RequestBody cliente c){
        return new ResponseEntity<>(this.cs.create(c), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<cliente>>finAll(){
        return new ResponseEntity<>(this.cs.findAll(), HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<cliente> update (@RequestBody cliente cUpdate, @PathVariable Long id) throws resourceNotFoundException {
        return new ResponseEntity<>(this.cs.update(cUpdate, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delet(@PathVariable("id") Long id){
        cs.delet(id);
        return ResponseEntity.ok().build();
    }



}
