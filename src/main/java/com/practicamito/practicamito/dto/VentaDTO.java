package com.practicamito.practicamito.dto;

import com.practicamito.practicamito.model.DetalleVenta;
import com.practicamito.practicamito.model.Persona;

import java.time.LocalDateTime;

public class VentaDTO {

    private Integer idVenta;
    private LocalDateTime fecha;
    private Persona idPersona;
    private double importe;
    private DetalleVentaDTO detVta;

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

    public DetalleVentaDTO getDetVta() {
        return detVta;
    }

    public void setDetVta(DetalleVentaDTO detVta) {
        this.detVta = detVta;
    }
}
