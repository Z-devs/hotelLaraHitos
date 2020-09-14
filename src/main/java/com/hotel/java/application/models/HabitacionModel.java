package com.hotel.java.application.models;

import java.util.List;

public class HabitacionModel {
    private long id;
    private String codigo;
    private String descripcion;
    private float precio;
    List<TipoModel> tipoModelList;

    public HabitacionModel(String codigo, String descripcion, float precio, List<TipoModel> tipoModelList) {
        setCodigo (codigo);
        setDescripcion (descripcion);
        setPrecio (precio);
        setTipoModelList (tipoModelList);
    }

    public HabitacionModel(long id, String codigo, String descripcion, float precio, List<TipoModel> tipoModelList) {
        setId (id);
        setCodigo (codigo);
        setDescripcion (descripcion);
        setPrecio (precio);
        setTipoModelList (tipoModelList);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public List<TipoModel> getTipoModelList() {
        return tipoModelList;
    }

    public void setTipoModelList(List<TipoModel> tipoModelList) {
        this.tipoModelList = tipoModelList;
    }

    @Override
    public String toString() {
        return "HabitacionModel{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", tipoModelList=" + tipoModelList +
                '}';
    }
}
