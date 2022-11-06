package com.nahuelchp.service;

import com.nahuelchp.exception.ResourceNotFoundException;
import com.nahuelchp.model.Cliente;
import com.nahuelchp.model.Producto;
import com.nahuelchp.model.Venta;
import com.nahuelchp.model.VentaDetalle;
import com.nahuelchp.repository.ClienteRepository;
import com.nahuelchp.repository.ProductoRepository;
import com.nahuelchp.repository.VentaDetalleRepository;
import com.nahuelchp.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentasService {

    @Autowired
    private VentaRepository vr;
    @Autowired
    private ClienteRepository cr;
    @Autowired
    private VentaDetalleRepository vdr;
    @Autowired
    private ProductoRepository pr;

    public Venta create(Venta newVenta) throws ResourceNotFoundException {
        Venta v = new Venta();
        v.setFechaAlta(LocalDate.now());
        Optional<Cliente> cliente = cr.findById(newVenta.getCliente().getId());
        if (cliente.isPresent()) {
            v.setCliente(cliente.get());
        } else {
            throw new ResourceNotFoundException("No existe");
        }
        Venta venta = this.vr.save(v);
        List<VentaDetalle> detalleVenta = generarVentaDetalle(newVenta.getDetalle(),venta);

        Double total = detalleVenta.stream()
                .mapToDouble(VentaDetalle::getSubTotal)
                .sum();
        v.setTotal(total);

        List<VentaDetalle> saveDetalle = this.vdr.saveAll(detalleVenta);
        venta.setDetalle(saveDetalle);
        return venta;
    }

    private List<VentaDetalle> generarVentaDetalle(List<VentaDetalle> detalle, Venta venta) {
        List<VentaDetalle> detalleVenta = new ArrayList<>();
        detalle.forEach(item -> {
            try {
                VentaDetalle detalleItem = createVentaDetalle(item,venta);
                detalleVenta.add(detalleItem);
            } catch (ResourceNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        return detalleVenta;
    }

    private VentaDetalle createVentaDetalle(VentaDetalle newvd,Venta venta) throws ResourceNotFoundException {
        VentaDetalle vd = new VentaDetalle();
        vd.setVenta(venta);
        vd.setCantidad(newvd.getCantidad());
        Optional<Producto> producto = pr.findById(newvd.getProducto().getId());
        if (producto.isPresent()) {
            vd.setProducto(producto.get());
        } else {
            throw new ResourceNotFoundException("No existe");
        }

        vd.setSubTotal(vd.getProducto().getPrecioVenta() * vd.getCantidad());
        return vd;
    }
}
