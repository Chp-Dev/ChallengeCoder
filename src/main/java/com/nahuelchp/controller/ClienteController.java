package com.nahuelchp.controller;


import com.nahuelchp.exception.ResourceNotFoundException;
import com.nahuelchp.model.Cliente;
import com.nahuelchp.service.ClienteService;
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
    public ResponseEntity delet(@PathVariable("id") Long id) throws ResourceNotFoundException {
        cs.delete(id);
        return ResponseEntity.ok().build();
    }



}
