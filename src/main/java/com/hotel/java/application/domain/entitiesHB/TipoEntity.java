package com.hotel.java.application.domain.entitiesHB;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tipo", schema = "hotel", catalog = "")
public class TipoEntity {
    private int id;
    private String nombre;
    private String descripcion;
    private Collection<HabitacionEntity> habitacionsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 45)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(mappedBy = "tipoByTipoId")
    public Collection<HabitacionEntity> getHabitacionsById() {
        return habitacionsById;
    }

    public void setHabitacionsById(Collection<HabitacionEntity> habitacionsById) {
        this.habitacionsById = habitacionsById;
    }
}
