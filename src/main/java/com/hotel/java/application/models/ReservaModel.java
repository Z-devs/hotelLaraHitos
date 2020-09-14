package com.hotel.java.application.models;

import java.sql.Timestamp;
import java.util.List;

public class ReservaModel {
    private long id;
    private java.sql.Timestamp fechaIn;
    private java.sql.Timestamp fechaOut;
    private float precioTotal;
    List<ClienteModel> clienteModelList;
    List<HabitacionModel> habitacionModels;

    public ReservaModel(Timestamp fechaIn, Timestamp fechaOut, float precioTotal, List<ClienteModel> clienteModelList, List<HabitacionModel> habitacionModels) {
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteModelList (clienteModelList);
        setHabitacionModels (habitacionModels);
    }

    public ReservaModel(long id, Timestamp fechaIn, Timestamp fechaOut, float precioTotal, List<ClienteModel> clienteModelList, List<HabitacionModel> habitacionModels) {
        setId (id);
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteModelList (clienteModelList);
        setHabitacionModels (habitacionModels);
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

    public List<ClienteModel> getClienteModelList() {
        return clienteModelList;
    }

    public void setClienteModelList(List<ClienteModel> clienteModelList) {
        this.clienteModelList = clienteModelList;
    }

    public List<HabitacionModel> getHabitacionModels() {
        return habitacionModels;
    }

    public void setHabitacionModels(List<HabitacionModel> habitacionModels) {
        this.habitacionModels = habitacionModels;
    }

    @Override
    public String toString() {
        return "ReservaModel{" +
                "fechaIn=" + fechaIn +
                ", fechaOut=" + fechaOut +
                ", precioTotal=" + precioTotal +
                ", clienteModelList=" + clienteModelList +
                ", habitacionModels=" + habitacionModels +
                '}';
    }
}
