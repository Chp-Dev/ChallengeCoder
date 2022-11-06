package com.nahuelchp.service;

import com.nahuelchp.exception.ResourceNotFoundException;
import com.nahuelchp.model.Producto;
import com.nahuelchp.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository pr;


    public Producto create (Producto newProduct){
        Producto p = new Producto();
        p.setDescripcion(newProduct.getDescripcion());
        p.setPrecioCompra(newProduct.getPrecioCompra());
        p.setPrecioVenta(newProduct.getPrecioVenta());
        p.setStock(newProduct.getStock());
        p.setFechaAlta(LocalDate.now());
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
            throw new ResourceNotFoundException("El Producto no existe");
        }
    }

    public void delet(Long id){
        pr.deleteById(id);
    }


}
