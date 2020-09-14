package com.hotel.java.application.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="tipo")
public class TipoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "habitacion")
    List<HabitacionEntity> habitacionEntityList;

    public TipoEntity(String nombre, String descripcion) {
        setNombre (nombre);
        setDescripcion (descripcion);
    }

    public TipoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoEntity{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", habitacionEntityList=" + habitacionEntityList +
                '}';
    }
}
