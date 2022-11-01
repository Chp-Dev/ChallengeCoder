package com.coderJava.jpaservice.service;

import com.coderJava.jpaservice.controller.ResourceNotFoundException;
import com.coderJava.jpaservice.model.Cliente;
import com.coderJava.jpaservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteService {

    @Autowired
    private ClienteRepository cr;

    public Cliente create (Cliente newClient){
        Cliente c = new Cliente();
        c.setApellido(newClient.getApellido());
        c.setNombre(newClient.getNombre());
        c.setDni(newClient.getDni());
        c.setFechaNacimiento(newClient.getFechaNacimiento());
        return this.cr.save(c);
    }

    public List<Cliente> findAll(){
        return this.cr.findAll();
    }


    public Cliente update (Cliente c, Long id) throws ResourceNotFoundException {
        Optional<Cliente> cb = this.cr.findById(id);
        if (cb.isPresent()){
            Cliente newC = cb.get();
            newC.setApellido(c.getApellido());
            newC.setNombre(c.getNombre());
            newC.setDni(c.getDni());
            newC.setFechaNacimiento(c.getFechaNacimiento());
            return this.cr.save(newC);
        }else{
            throw new ResourceNotFoundException("El cliente no existe");
        }
    }

    public boolean delet(Long id){
        try {
            cr.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }





}
