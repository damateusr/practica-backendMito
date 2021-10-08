package com.practicamito.practicamito.model;

import javax.persistence.*;

@Entity
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;
    @ManyToOne
    @JoinColumn(name="idVenta",nullable = false,foreignKey = @ForeignKey(name="FK_VENTA"))
    private Venta idVenta;
    @ManyToOne
    @JoinColumn(name="idProducto",nullable = false,foreignKey = @ForeignKey(name="FK_PRODUCTO"))
    private Producto idProducto;
    @Column(nullable = false)
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

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
