package com.coderJava.jpaservice.controller;


import com.coderJava.jpaservice.model.Cliente;
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
    public ResponseEntity<Cliente> create (@RequestBody Cliente c){
        return new ResponseEntity<>(this.cs.create(c), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>>finAll(){
        return new ResponseEntity<>(this.cs.findAll(), HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Cliente> update (@RequestBody Cliente cUpdate, @PathVariable("id") Long id) throws ResourceNotFoundException{
        return new ResponseEntity<>(this.cs.update(cUpdate, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public String deletId(@PathVariable("id") Long id){
        boolean yes = this.cs.delet(id);
        if (yes){
            return "Se elimino el usuario con ID " + id;
        }else {
            return "No puedo eliminar el usuario con ID " + id;
        }
    }

}
