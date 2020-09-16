package com.hotel.java.application.models;

import java.sql.Timestamp;
import java.util.List;

public class ReservaModel {
    private long id;
    private java.sql.Timestamp fechaIn;
    private java.sql.Timestamp fechaOut;
    private float precioTotal;
    ClienteModel clienteModel;
    HabitacionModel habitacionModel;

    public ReservaModel(Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteModel clienteModel, HabitacionModel habitacionModel) {
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteModelList (clienteModel);
        setHabitacionModel (habitacionModel);
    }

    public ReservaModel(long id, Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteModel clienteModel, HabitacionModel habitacionModel) {
        setId (id);
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteModelList (clienteModel);
        setHabitacionModel (habitacionModel);
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

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModelList(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public HabitacionModel getHabitacionModel() {
        return habitacionModel;
    }

    public void setHabitacionModel(HabitacionModel habitacionModel) {
        this.habitacionModel = habitacionModel;
    }

    @Override
    public String toString() {
        return "ReservaModel{" +
                "fechaIn=" + fechaIn +
                ", fechaOut=" + fechaOut +
                ", precioTotal=" + precioTotal +
                ", clienteModel=" + clienteModel +
                ", habitacionModels=" + habitacionModel +
                '}';
    }
}
