package com.hotel.java.application.domain.entities;

import javax.persistence.*;

@Entity
@Table (name="habitacion")
public class HabitacionEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private String descripcion;
    private float precio;

    @ManyToOne
    @JoinColumn (name="id_tipo")
    private TipoEntity tipoEntity_id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private ReservaEntity reservaEntity;

    public HabitacionEntity(long id, String codigo, String descripcion, float precio, TipoEntity tipoEntity_id) {
        setId (id);
        setCodigo (codigo);
        setDescripcion (descripcion);
        setPrecio (precio);
        setTipoEntity_id (tipoEntity_id);
    }

    public HabitacionEntity(String codigo, String descripcion, float precio, TipoEntity tipoEntity_id) {
        setCodigo (codigo);
        setDescripcion (descripcion);
        setPrecio (precio);
        setTipoEntity_id (tipoEntity_id);
    }

    public HabitacionEntity() {
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

    public TipoEntity getTipoEntity_id() {
        return tipoEntity_id;
    }

    public void setTipoEntity_id(TipoEntity tipoEntity) {
        this.tipoEntity_id = tipoEntity;
    }

    public ReservaEntity getReservaEntity() {
        return reservaEntity;
    }

    public void setReservaEntity(ReservaEntity reservaEntity) {
        this.reservaEntity = reservaEntity;
    }

    @Override
    public String toString() {
        return "HabitacionEntity{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", tipoEntity=" + tipoEntity_id +
                ", reservaEntity=" + reservaEntity +
                '}';
    }
}
