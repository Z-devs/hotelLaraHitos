package com.hotel.java.application.models;

import java.sql.Timestamp;

public class ReservaModel {
    private long id;
    private java.sql.Timestamp fechaIn;
    private java.sql.Timestamp fechaOut;
    private float precioTotal;
    ClienteModel cliente;
    HabitacionModel habitacion;

    public ReservaModel(Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteModel cliente, HabitacionModel habitacion) {
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setCliente (cliente);
        setHabitacion (habitacion);
    }

    public ReservaModel(long id, Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteModel cliente, HabitacionModel habitacion) {
        setId (id);
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setCliente (cliente);
        setHabitacion (habitacion);
    }

    public ReservaModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Timestamp fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Timestamp getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(Timestamp fechaOut) {
        this.fechaOut = fechaOut;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel clienteModel) {
        this.cliente = clienteModel;
    }

    public HabitacionModel getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionModel habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "ReservaModel{" +
                "fechaIn=" + fechaIn +
                ", fechaOut=" + fechaOut +
                ", precioTotal=" + precioTotal +
                ", clienteModel=" + cliente +
                ", habitacionModels=" + habitacion +
                '}';
    }
}
