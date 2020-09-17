package com.hotel.java.application.domain.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp fechaIn;
    private Timestamp fechaOut;
    private float precioTotal;

    @ManyToOne
    @JoinColumn (name="id_cliente")
    private ClienteEntity clienteEntity_id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private HabitacionEntity habitacionEntity_id;

    public ReservaEntity(long id, Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteEntity clienteEntity_id, HabitacionEntity habitacionEntity) {
        setId (id);
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteEntity_id (clienteEntity_id);
        setHabitacionEntity_id (habitacionEntity);
    }

    public ReservaEntity(Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteEntity clienteEntity_id, HabitacionEntity habitacionEntity) {
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteEntity_id (clienteEntity_id);
        setHabitacionEntity_id (habitacionEntity);
    }

    public ReservaEntity() {
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

    public ClienteEntity getClienteEntity_id() {
        return clienteEntity_id;
    }

    public void setClienteEntity_id(ClienteEntity clienteEntity) {
        this.clienteEntity_id = clienteEntity;
    }

    public HabitacionEntity getHabitacionEntity_id() {
        return habitacionEntity_id;
    }

    public void setHabitacionEntity_id(HabitacionEntity habitacionEntity) {
        this.habitacionEntity_id = habitacionEntity;
    }



    @Override
    public String toString() {
        return "ReservaEntity{" +
                "fechaIn=" + fechaIn +
                ", fechaOut=" + fechaOut +
                ", precioTotal=" + precioTotal +
                ", clienteEntity=" + clienteEntity_id +
                ", habitacionEntity=" + habitacionEntity_id +
                '}';
    }

    @ManyToOne(optional = false)
    private ClienteEntity clienteEntities;

    public ClienteEntity getClienteEntities() {
        return clienteEntities;
    }

    public void setClienteEntities(ClienteEntity clienteEntities) {
        this.clienteEntities = clienteEntities;
    }
}
