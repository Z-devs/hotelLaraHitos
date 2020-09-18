package com.hotel.java.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "reserva")
public class ReservaEntity implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp fechaIn;
    private Timestamp fechaOut;
    private float precioTotal;

    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private ClienteEntity cliente;

    @OneToOne
    @JoinColumn(name="id_habitacion")
    private HabitacionEntity habitacion;

    public ReservaEntity(long id, Timestamp fechaIn, Timestamp fechaOut, float precioTotal, ClienteEntity clienteEntity_id, HabitacionEntity habitacion) {
        setId (id);
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteEntity_id (clienteEntity_id);
        setHabitacionEntity_id (habitacion);
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
        return cliente;
    }

    public void setClienteEntity_id(ClienteEntity clienteEntity) {
        this.cliente = clienteEntity;
    }

    public HabitacionEntity getHabitacion() {
        return habitacion;
    }

    public void setHabitacionEntity_id(HabitacionEntity habitacion) {
        this.habitacion = habitacion;
    }


    @Override
    public String toString() {
        return "ReservaEntity{" +
                "fechaIn=" + fechaIn +
                ", fechaOut=" + fechaOut +
                ", precioTotal=" + precioTotal +
                ", clienteEntity=" + cliente +
                //", habitacionEntity=" + habitacionEntity_id +
                '}';
    }

}
