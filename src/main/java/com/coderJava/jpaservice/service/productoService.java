package com.coderJava.jpaservice.service;

import com.coderJava.jpaservice.controller.ResourceNotFoundException;
import com.coderJava.jpaservice.model.Cliente;
import com.coderJava.jpaservice.model.Producto;
import com.coderJava.jpaservice.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productoService {

    @Autowired
    private ProductoRepository pr;


    public Producto create (Producto newProduct){
        Producto p = new Producto();
        p.setDescripcion(newProduct.getDescripcion());
        p.setPrecioCompra(newProduct.getPrecioCompra());
        p.setPrecioVenta(newProduct.getPrecioVenta());
        p.setStock(newProduct.getStock());
        return this.pr.save(p);
    }

    public List<Producto> findAll(){
        return this.pr.findAll();
    }


    public Producto update (Producto p, Long id) throws ResourceNotFoundException {
        Optional<Producto> pb = this.pr.findById(id);
        if (pb.isPresent()){
            Producto newP = pb.get();
            newP.setDescripcion(p.getDescripcion());
            newP.setPrecioCompra(p.getPrecioCompra());
            newP.setPrecioVenta(p.getPrecioVenta());
            newP.setStock(p.getStock());
            return this.pr.save(newP);
        }else{
            throw new ResourceNotFoundException("El producto no existe");
        }
    }

    public boolean delet(Long id){
        try {
            pr.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
