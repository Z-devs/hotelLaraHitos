package com.hotel.java.application.domain.entitiesHB;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "reserva", schema = "hotel", catalog = "")
public class ReservaEntity {
    private long id;
    private Timestamp fechaIn;
    private Timestamp fechaOut;
    private Integer precioTotal;
    private Collection<HabitacionEntity> habitacionsById;
    private ClienteEntity clienteByClienteId;




    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fechaIn", nullable = true)
    public Timestamp getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Timestamp fechaIn) {
        this.fechaIn = fechaIn;
    }

    @Basic
    @Column(name = "fechaOut", nullable = true)
    public Timestamp getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(Timestamp fechaOut) {
        this.fechaOut = fechaOut;
    }

    @Basic
    @Column(name = "precioTotal", nullable = true, precision = 0)
    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    @OneToMany(mappedBy = "reservaByReservaId")
    public Collection<HabitacionEntity> getHabitacionsById() {
        return habitacionsById;
    }

    public void setHabitacionsById(Collection<HabitacionEntity> habitacionsById) {
        this.habitacionsById = habitacionsById;
    }

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    public ClienteEntity getClienteByClienteId() {
        return clienteByClienteId;
    }

    public void setClienteByClienteId(ClienteEntity clienteByClienteId) {
        this.clienteByClienteId = clienteByClienteId;
    }
}
