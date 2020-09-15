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
    private ClienteEntity clienteEntity;

    @OneToOne
    @JoinColumn (name="id_habitacion")
    private HabitacionEntity habitacionEntity;

    public ReservaEntity(long id, Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteEntity clienteEntity, HabitacionEntity habitacionEntity) {
        setId (id);
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteEntity (clienteEntity);
        setHabitacionEntity (habitacionEntity);
    }

    public ReservaEntity(Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteEntity clienteEntity, HabitacionEntity habitacionEntity) {
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteEntity (clienteEntity);
        setHabitacionEntity (habitacionEntity);
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

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public HabitacionEntity getHabitacionEntity() {
        return habitacionEntity;
    }

    public void setHabitacionEntity(HabitacionEntity habitacionEntity) {
        this.habitacionEntity = habitacionEntity;
    }



    @Override
    public String toString() {
        return "ReservaEntity{" +
                "fechaIn=" + fechaIn +
                ", fechaOut=" + fechaOut +
                ", precioTotal=" + precioTotal +
                ", clienteEntity=" + clienteEntity +
                ", habitacionEntity=" + habitacionEntity +
                '}';
    }
}
