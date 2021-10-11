package com.practicamito.practicamito.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    @Column(nullable = false)
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name="idPersona",nullable = false,foreignKey = @ForeignKey(name="FK_PERSONA"))
    private Persona idPersona;
    @Column(nullable = false)
    private double importe;


    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
