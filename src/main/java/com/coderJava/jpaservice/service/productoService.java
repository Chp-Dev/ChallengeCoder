package com.coderJava.jpaservice.service;

import com.coderJava.jpaservice.controller.resourceNotFoundException;
import com.coderJava.jpaservice.model.producto;
import com.coderJava.jpaservice.repository.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productoService {

    @Autowired
    private productoRepository pr;


    public producto create (producto newProduct){
        producto p = new producto();
        p.setDescripcion(newProduct.getDescripcion());
        p.setPrecioCompra(newProduct.getPrecioCompra());
        p.setPrecioVenta(newProduct.getPrecioVenta());
        p.setStock(newProduct.getStock());
        return this.pr.save(p);
    }

    public List<producto> findAll(){
        return this.pr.findAll();
    }


    public producto update (producto p, Long id) throws resourceNotFoundException {
        Optional<producto> pb = this.pr.findById(id);
        if (pb.isPresent()){
            producto newP = pb.get();
            newP.setDescripcion(p.getDescripcion());
            newP.setPrecioCompra(p.getPrecioCompra());
            newP.setPrecioVenta(p.getPrecioVenta());
            newP.setStock(p.getStock());
            return this.pr.save(newP);
        }else{
            throw new resourceNotFoundException("El producto no existe");
        }
    }

    public void delet(Long id){
        pr.deleteById(id);
    }


}
