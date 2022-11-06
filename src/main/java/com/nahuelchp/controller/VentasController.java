package com.nahuelchp.controller;

import com.nahuelchp.exception.ResourceNotFoundException;
import com.nahuelchp.model.Producto;
import com.nahuelchp.model.Venta;
import com.nahuelchp.service.ProductoService;
import com.nahuelchp.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/comprobante")
@RestController
public class VentasController {
    @Autowired
    private VentasService vs;

    @PostMapping("/")
    public ResponseEntity<Venta> create (@RequestBody Venta v) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.vs.create(v), HttpStatus.OK);
    }

}
