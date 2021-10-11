package com.practicamito.practicamito.dto;

import com.practicamito.practicamito.model.Persona;
import com.practicamito.practicamito.model.Producto;
import com.practicamito.practicamito.model.Venta;

import java.time.LocalDateTime;

public class DetalleVentaDTO {

    private Integer idDetalleVenta;
    private Venta idVenta;
    private ProductoDTO producto;
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

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
