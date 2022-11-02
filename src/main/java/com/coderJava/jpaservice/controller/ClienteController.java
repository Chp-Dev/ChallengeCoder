package com.coderJava.jpaservice.controller;


import com.coderJava.jpaservice.model.Cliente;
import com.coderJava.jpaservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping(path = "api/client")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService cs;

    @PostMapping("/")
    public ResponseEntity<Cliente> create (@RequestBody Cliente c){
        return new ResponseEntity<>(this.cs.create(c), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>>finAll(){
        return new ResponseEntity<>(this.cs.findAll(), HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Cliente> update (@RequestBody Cliente cUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.cs.update(cUpdate, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delet(@PathVariable("id") Long id){
        cs.delet(id);
        return ResponseEntity.ok().build();
    }



}
