package com.practicamito.practicamito.dto;

import com.practicamito.practicamito.model.Persona;
import com.practicamito.practicamito.model.Producto;
import com.practicamito.practicamito.model.Venta;

import java.time.LocalDateTime;

public class DetalleVentaDTO {

    private Integer idDetalleVenta;
    private Venta idVenta;
    private ProductoDTO idProducto;
    private Integer cantidad;

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    public ProductoDTO getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ProductoDTO idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
