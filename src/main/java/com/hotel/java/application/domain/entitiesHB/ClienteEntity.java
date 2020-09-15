package com.hotel.java.application.domain.entitiesHB;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cliente", schema = "hotel", catalog = "")
public class ClienteEntity {
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private Collection<LoginEntity> loginsById;
    private Collection<ReservaEntity> reservasById;

    public ClienteEntity(long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.loginsById = loginsById;
        this.reservasById = reservasById;
    }

    public ClienteEntity(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.loginsById = loginsById;
        this.reservasById = reservasById;
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
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
    @Column(name = "apellido", nullable = true, length = 45)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "clienteByClienteId")
    public Collection<LoginEntity> getLoginsById() {
        return loginsById;
    }

    public void setLoginsById(Collection<LoginEntity> loginsById) {
        this.loginsById = loginsById;
    }

    @OneToMany(mappedBy = "clienteByClienteId")
    public Collection<ReservaEntity> getReservasById() {
        return reservasById;
    }

    public void setReservasById(Collection<ReservaEntity> reservasById) {
        this.reservasById = reservasById;
    }
}
