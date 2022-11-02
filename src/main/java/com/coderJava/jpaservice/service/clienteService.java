package com.coderJava.jpaservice.service;

import com.coderJava.jpaservice.controller.resourceNotFoundException;
import com.coderJava.jpaservice.model.cliente;
import com.coderJava.jpaservice.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteService {

    @Autowired
    private clienteRepository cr;

    public cliente create (cliente newClient){
        cliente c = new cliente();
        c.setApellido(newClient.getApellido());
        c.setNombre(newClient.getNombre());
        c.setDni(newClient.getDni());
        c.setFechaNacimiento(newClient.getFechaNacimiento());
        return this.cr.save(c);
    }

    public List<cliente> findAll(){
        return this.cr.findAll();
    }


    public cliente update (cliente c, Long id) throws resourceNotFoundException {
        Optional<cliente> cb = this.cr.findById(id);
        if (cb.isPresent()){
            cliente newC = cb.get();
            newC.setApellido(c.getApellido());
            newC.setNombre(c.getNombre());
            newC.setDni(c.getDni());
            newC.setFechaNacimiento(c.getFechaNacimiento());
            return this.cr.save(newC);
        }else{
            throw new resourceNotFoundException("El cliente no existe");
        }
    }


    public void delet(Long id){
        cr.deleteById(id);
    }






}
